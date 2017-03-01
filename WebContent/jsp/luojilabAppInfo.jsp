<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="language" content="en" />
	<meta name="viewport" content="width=device-width,height=device-height, initial-scale=1, user-scalable=no, minimal-ui">
   	<meta name="apple-mobile-web-app-capable" content="yes">
   	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="0">
   	<%response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
	response.flushBuffer();%>
	<script src="themes/js/jquery.min.js" type="text/javascript"></script>
	<script src="themes/js/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="themes/js/jquery.calendar.js" type="text/javascript"></script>
	<script src="themes/js/jquery.combo.js" type="text/javascript"></script>
	<script src="themes/js/jquery.datebox.js" type="text/javascript"></script>
	<script src="themes/js/easyui-lang-zh_CN.js" type="text/javascript"></script>
	<link href="themes/css/welcome.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/tabs.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/icon.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/easyui.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/panel.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/linkbutton.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/datagrid.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/combo.css" rel="stylesheet" type="text/css" />
	<link href="themes/css/calendar.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		ul li{
			list-style-type:none;
		}
	</style>
	<title>得到应用商城</title>
</head>
<body class="easyui-layout layout"
	style="width: 100%; height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	<div id="tb" style="padding: 3px;background-color: rgb(219, 227, 239);">
		<br>
			<s:form id="searchInput" action="appInfo" namespace="/" method="post">
				<span>系统:&nbsp;</span> 
					<select name="os_name" style="width:90px;" class="easyui-combobox combobox-f combo-f" style="width: 80px; display: none;" editable="false" panelheight="auto" >
						<option value="0" <%if("0".equals(request.getAttribute("os_name")))out.print("selected");%>>全部</option>
						<option value="1" <%if("1".equals(request.getAttribute("os_name")))out.print("selected");%>>Android</option>
						<option value="2" <%if("2".equals(request.getAttribute("os_name")))out.print("selected");%>>IOS</option>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span>环境:&nbsp;</span> 
					<select name="config" style="width:90px;" class="easyui-combobox combobox-f combo-f" style="width: 80px; display: none;" editable="false" panelheight="auto" >
						<option value="0" <%if("0".equals(request.getAttribute("config")))out.print("selected");%>>全部</option>
						<option value="1" <%if("1".equals(request.getAttribute("config")))out.print("selected");%>>测试</option>
						<option value="2" <%if("2".equals(request.getAttribute("config")))out.print("selected");%>>仿真</option>
						<option value="3" <%if("3".equals(request.getAttribute("config")))out.print("selected");%>>线上</option>
					</select><br><br>
				<span>版本:&nbsp;</span>
					<select name="versions" style="width:90px;" class="easyui-combobox combobox-f combo-f" style="width: 80px; display: none;" editable="false" panelheight="auto" >
						<option value="0" selected="selected">全部</option>
						<sql:setDataSource var="version_info" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://ai.luojilab.com:3406/luojilab" user="root" password="123wujiecao@TEST"/>
						<sql:query dataSource="${version_info}" var="result">SELECT distinct versions from luojilab_app_info order by versions asc;</sql:query>
						<c:forEach items="${result.rows}" var="row" varStatus="row_id">
							<option value="<c:out value="${row.versions}"/>"><c:out value="${row.versions}"/></option>
						</c:forEach>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span>日期:&nbsp;</span> 
					<select name="app_time" style="width:90px;" class="easyui-combobox combobox-f combo-f" style="width: 80px; display: none;" editable="false" panelheight="auto" >
						<option value="0" <%if("0".equals(request.getAttribute("app_time")))out.print("selected");%>>全部</option>
						<option value="1" <%if("1".equals(request.getAttribute("app_time")))out.print("selected");%>>最近1天</option>
						<option value="2" <%if("2".equals(request.getAttribute("app_time")))out.print("selected");%>>最近3天</option>
						<option value="3" <%if("3".equals(request.getAttribute("app_time")))out.print("selected");%>>最近7天</option>
						<option value="4" <%if("4".equals(request.getAttribute("app_time")))out.print("selected");%>>最近30天</option>
					</select><br>
											
				&nbsp;<input type="submit" class="easyui-linkbutton l-btn" style="height:30px; width:60px; float:right;"value="查询">
			</s:form>
			<iframe name="postTo" style="display:none"></iframe><br>
	<div style="color:red;" align="center">请使用浏览器访问，点击下载安装</div>
	<div style="color:red;" align="center">默认只显示最新的仿真包，更多请查询</div>
	
	<div style="width:100%; height:72%; overflow-y: auto; position:absolute;">
	<table id="tt" class="" style="width:100%;height:120%;position:relative; overflow-y:auto">
		<tbody>
 			<s:set name="nums" value="0" />
				<tr style="width:100%; height:100%; position:relative; overflow-y:auto">
					<s:iterator value="infos">
 					<s:set name="nums" value="#nums+1" />
						<td style="width:100px" align="center">
					 		<div>
					 			<img src="<s:property value="qrcode_path"/>"></img>
					 			</div>
					 		<div>
					 			<input type="button" value="下载安装" maxlength="15" 
					 			onclick="window.location.href='<s:property value="app_path"/>'">
					 		</div>
					 		<div>
					 			<s:property value="os_name"/><s:property value="config"/><s:property value="versions"/>
					 		</div>
							<div>
								<s:property value="app_time.substring(0,app_time.length()-2)"/>
							</div>
							<br>
						</td>
						<s:if test="#nums%2==0">
							<tr style="display:none;"></tr>
						</s:if>
					</s:iterator>
				</tr>
		</tbody>
	</table>
	</div>
</body>
</html>