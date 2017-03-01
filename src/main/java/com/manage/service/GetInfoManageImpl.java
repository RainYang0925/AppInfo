package com.manage.service;

import java.util.List;

import com.manage.dao.GetInfoDAO;
import com.manage.dao.GetInfoDAOImpl;
import com.manage.model.LuojilabAppInfo;
import com.manage.util.RandomStr;

public class GetInfoManageImpl implements GetInfoManage {

	private GetInfoDAO getInfoDAO = new GetInfoDAOImpl();
	
	public GetInfoDAO getGetInfoDAO() {
		return getInfoDAO;
	}

	public void setGetInfoDAO(GetInfoDAO getInfoDAO) {
		this.getInfoDAO = getInfoDAO;
	}

	
	public String initSuccess_rate(String success_rate) {
		switch(Integer.parseInt(success_rate)) {
		case 0:
			success_rate = "like '%%%'";
			break;
		case 1:
			success_rate =  "like '%100.00%%'";
			break;
		case 2:
			success_rate =  "not like '%100.00%%'";
			break;
		}
		
		return success_rate;
	}
	
	public String initProject_name(String project_name) {
		System.out.println("project_name = " + project_name);
		switch(Integer.parseInt(project_name)) {
		case 0:
			project_name = "";
			break;
		case 1:
			project_name =  "pc";
			break;
		case 2:
			project_name =  "h5";
			break;
		case 3:
			project_name =  "android";
			break;
		case 4:
			project_name =  "ios";
			break;
		}
		
		return project_name;
	}
	
	public String initProduct_name(String product_name) {
		switch(Integer.parseInt(product_name)) {
		case 0:
			product_name = "";
			break;
		case 1:
			product_name =  "allin";
			break;
		case 2:
			product_name =  "medplus";
			break;
		}
		
		return product_name;
	}
	
	public String initResult_start_date(String result_start_date) {
		if(result_start_date == null || result_start_date.isEmpty()) {
			result_start_date = "1970-01-01 00:00:00";
		} else {
			result_start_date += " 00:00:00";
		}
		
		return result_start_date;
	}
	
	public String initResult_end_date(String result_end_date) {
		if(result_end_date == null || result_end_date.isEmpty()) {
			result_end_date = "2100-01-01 23:59:59";
		} else {
			result_end_date += " 23:59:59";
		}
		
		return result_end_date;
	}
	
	@Override
	public List<LuojilabAppInfo> getHttpServletAppInfo(LuojilabAppInfo info) {
		String os_name = info.getOs_name();
		String config = info.getConfig();
		String versions = info.getVersions();
		String app_time = info.getApp_time();
		boolean defaults = false;
		if(os_name == null || os_name.equals("0")) {
			os_name = "";
		} else if (os_name.equals("1")) {
			os_name = "Android";
		} else if (os_name.equals("2")) {
			os_name = "IOS";
		}
		
		// Ĭ����ʾ���滷���İ�
		if(config == null) {
			config = "����";
		} else if (config.equals("0")) {
			config = "";
		} else if (config.equals("1")) {
			config = "����";
		} else if (config.equals("2")) {
			config = "����";
		} else if (config.equals("3")) {
			config = "����";
		}
		
		if(versions == null || versions.equals("0")) {
			versions = "";
		}
		
		RandomStr random = new RandomStr();
		if (app_time == null) {
			app_time = random.currentDate(-7) + " 00:00:00";
			defaults = true;
		} else if(app_time.equals("0")) {
			app_time = "1970-01-01 00:00:00";
		} else if (app_time.equals("1")) {
			app_time = random.currentDate(-1) + " 00:00:00";
		} else if (app_time.equals("2")) {
			app_time = random.currentDate(-3) + " 00:00:00";
		} else if (app_time.equals("3")) {
			app_time = random.currentDate(-7) + " 00:00:00";
		} else if (app_time.equals("4")) {
			app_time = random.currentDate(-30) + " 00:00:00";
		}
		
		return getInfoDAO.getHttpServletAppInfo(os_name, config, versions, app_time, defaults);
	}

}
