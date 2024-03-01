<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<h1 style="color: green; text-align: center;">Register Employee Form</h1>
<f:form modelAttribute="emp">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Employee Number :</td>
			<td><f:input path="eno"/></td>
		</tr>
		<tr>
			<td>Employee Name :</td>
			<td><f:input path="ename"/></td>
		</tr>
		<tr>
			<td>Employee Address :</td>
			<td><f:input path="eaddrs"/></td>
		</tr>
		<tr>
			<td>Employee Salary :</td>
			<td><f:input path="salary"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>
	</table>
</f:form>