package com.manage.dao;

import java.util.List;

import com.manage.model.LuojilabAppInfo;

public interface GetInfoDAO {
	
	public List<LuojilabAppInfo> getHttpServletAppInfo(String os_name, String config, String versions, String app_time, boolean defaults);
	
}
