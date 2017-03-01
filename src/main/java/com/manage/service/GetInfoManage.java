package com.manage.service;

import java.util.List;

import com.manage.model.AllinLoadTestResultsInfo;
import com.manage.model.AllinUITestResultsInfo;
import com.manage.model.AppInfo;
import com.manage.model.LuojilabAppInfo;
import com.manage.model.LuojilabLeakInfo;
import com.manage.model.TestResultsInfo;

public interface GetInfoManage {
	public List<LuojilabAppInfo> getHttpServletAppInfo(LuojilabAppInfo string);
}
