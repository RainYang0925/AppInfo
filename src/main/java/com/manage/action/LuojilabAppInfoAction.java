package com.manage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.manage.model.LuojilabAppInfo;
import com.manage.service.GetInfoManage;
import com.manage.service.GetInfoManageImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LuojilabAppInfoAction extends ActionSupport {
	private String app_name;
	private String os_name;
	private String config;
	private String versions;
	private String app_path;
	private String qrcode_path;
	private String app_time;
	private int id;
	
	private List<LuojilabAppInfo> infos;
	
	private LuojilabAppInfo appInfo = new LuojilabAppInfo();
	
	private GetInfoManage getInfo = new GetInfoManageImpl();
	
	@Override
	public String execute() throws Exception {
        System.out.println("os_name = " + os_name);
        System.out.println("config = " + config);
        System.out.println("versions = " + versions);
        System.out.println("app_time = " + app_time);
        appInfo.setOs_name(os_name);
        appInfo.setConfig(config);
        appInfo.setVersions(versions);
        appInfo.setApp_time(app_time);
        
		this.infos = this.getInfo.getHttpServletAppInfo(appInfo);
		
		for(int i = 0; i < infos.size(); i++) {
			LuojilabAppInfo result = infos.get(i);
			System.out.println(result.getApp_name() + " = " + result.getConfig());
		}
		
		return "success";
	}
	
	public List<LuojilabAppInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<LuojilabAppInfo> infos) {
		this.infos = infos;
	}

	public GetInfoManage getGetInfo() {
		return getInfo;
	}

	public void setGetInfo(GetInfoManage getInfo) {
		this.getInfo = getInfo;
	}

	public String getOs_name() {
		return os_name;
	}

	public void setOs_name(String os_name) {
		this.os_name = os_name;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getVersions() {
		return versions;
	}

	public void setVersions(String versions) {
		this.versions = versions;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	public String getApp_path() {
		return app_path;
	}

	public void setApp_path(String app_path) {
		this.app_path = app_path;
	}

	public String getQrcode_path() {
		return qrcode_path;
	}

	public void setQrcode_path(String qrcode_path) {
		this.qrcode_path = qrcode_path;
	}

	public String getApp_time() {
		return app_time;
	}

	public void setApp_time(String app_time) {
		this.app_time = app_time;
	}
	
}
