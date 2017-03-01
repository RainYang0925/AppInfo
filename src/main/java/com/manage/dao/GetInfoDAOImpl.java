package com.manage.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manage.model.LuojilabAppInfo;
import com.manage.util.HibernateUtil;

public class GetInfoDAOImpl implements GetInfoDAO{
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LuojilabAppInfo> getHttpServletAppInfo(String os_name, 
			String config, String versions, String app_time, boolean defaults) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction transaction = null;
		List<LuojilabAppInfo> list = new LinkedList<LuojilabAppInfo>();
		
		if (defaults) {
			String sqlIOS = "from LuojilabAppInfo info"
					+ " where info.os_name like '%IOS%'"
					+ " and info.config like '%" + config + "%'"
					+ " ORDER BY info.app_time desc"
					+ " LIMIT 1";
			String sqlAndroid = "from LuojilabAppInfo info"
					+ " where info.os_name like '%Android%'"
					+ " and info.config like '%" + config + "%'"
					+ " ORDER BY info.app_time desc"
					+ " LIMIT 1";
			try {
				transaction = session.getTransaction();
				if (transaction != null && !transaction.wasCommitted() && !transaction.wasRolledBack() && transaction.isActive()) 
				{
					transaction.commit();
				} else if(transaction.wasRolledBack()){
				    transaction.rollback();
				}
				
				transaction.begin();
				Query queryIOS = session.createQuery(sqlIOS);
				queryIOS.setFirstResult(0);
				queryIOS.setMaxResults(1);
				list = queryIOS.list();
				
				Query queryAndroid = session.createQuery(sqlAndroid);
				queryAndroid.setFirstResult(0);
				queryAndroid.setMaxResults(1);
				
				list.addAll(queryAndroid.list());
				session.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		} else {
			String sqlStr = "from LuojilabAppInfo info"
			+ " where info.os_name like '%" + os_name + "%'"
			+ " and info.config like '%" + config + "%'"
			+ " and info.versions like '%" + versions + "%'"
			+ " and info.app_time >= '" + app_time + "'"
			+ " ORDER BY info.app_time desc";
			
			try {
				transaction = session.getTransaction();
				if (transaction != null && !transaction.wasCommitted() && !transaction.wasRolledBack() && transaction.isActive()) 
				{
					transaction.commit();
				} else if(transaction.wasRolledBack()){
				    transaction.rollback();
				}
				
				transaction.begin();
		//		System.out.println("sqlStr = " + sqlStr);
				list = session.createQuery(sqlStr).list();
	//			for(int i = 0; i < list.size(); i++) {
	//				LuojilabAppInfo result = list.get(i);
	//				System.out.println(result.getApp_name() + " = " + result.getConfig());
	//			}
				
				session.getTransaction().commit();
	        } catch (Exception e) {
	        	transaction.rollback();
	            e.printStackTrace();
	        }
		}
		return list;
	}

}
