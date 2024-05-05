<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<h1 style="text-align: center; color: green;">
	<spring:message code="cust.reg.title" />
</h1>
<form:form modelAttribute="customer">
	<table align="center" bgcolor="cyan">
		<tr>
			<td><spring:message code="cust.reg.name" /></td>
			<td><form:input path="cname" /></td>
		</tr>
		<tr>
			<td><spring:message code="cust.reg.addrs" /></td>
			<td><form:input path="cadd" /></td>
		</tr>
		<tr>
			<td><spring:message code="cust.reg.billAmt" /></td>
			<td><form:input path="billAmt" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="cust.reg.submit" />"></td>
		</tr>
	</table>
</form:form>
<br>
<br>
<p style="text-align: center;">
	Current Locale:<%=response.getLocale()%>
</p>
<br>
<br>
<p style="text-align: center;">
	<a href="?lang=en_US">English</a> <a href="?lang=hi_IN">Hindi</a> <a
		href="?lang=or_IN">Oriya</a> <a href="?lang=te_IN">Telgu</a> <a
		href="?lang=de_DE">Germany</a> <a href="?lang=zh_CN">Chinese</a> <a
		href="?lang=fr_FR">French</a>
</p>