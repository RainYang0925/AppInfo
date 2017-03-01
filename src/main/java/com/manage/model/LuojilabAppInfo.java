package com.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "luojilab_app_info")
public class LuojilabAppInfo {
	private String app_name;
	private String os_name;
	private String config;
	private String versions;
	private String app_path;
	private String qrcode_path;
	private String app_time;
	private int id;
	
	@Id
	@GeneratedValue
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