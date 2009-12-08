<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>ERRO</title>
</head>
<body>
Ocorreu um erro.<br/>
<s:property value="%{exception.message}"/>
<hr/>
<s:property value="%{exceptionStack}"/>

</body>
</html>