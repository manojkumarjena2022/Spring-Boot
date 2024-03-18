<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="register" modelAttribute="cricketer">
<p style="color: red;">
<form:errors path="*" />
</p>
	<table align="center">
		<tr>
			<td>Name :</td>
			<td><form:input path="cname" /></td>
		</tr>
		<tr>
			<td>Type :</td>
			<td><form:input path="type" /></td>
		</tr>
		<tr>
			<td>DOB :</td>
			<td><form:input path="dob" type="date" /></td>
		</tr>
		<tr>
			<td>DOB Time :</td>
			<td><form:input path="tob" type="time" /></td>
		</tr>
		<tr>
			<td>DOJ and time :</td>
			<td><form:input path="doj" type="datetime-local" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"/></td>
			<td><input type="reset" value="Reset"/></td>
		</tr>
	</table>
</form:form>
