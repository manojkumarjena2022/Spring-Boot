<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="text-align: center; color: green;">Marriage Seeker
	Registration</h1>
<form:form modelAttribute="profile" enctype="multipart/form-data">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Marriage Seeker Name</td>
			<td><form:input path="profileName" /></td>
		</tr>
		<tr>
			<td>Marriage Seeker Gender</td>
			<td><form:radiobutton path="gender" value="Male" />&nbsp;&nbsp;Male<form:radiobutton
					path="gender" value="Female" />&nbsp;&nbsp;Female</td>
		</tr>
		<tr>
			<td>Select Resume</td>
			<td><form:input type="file" path="resume" /></td>
		</tr>
		<tr>
			<td>Select Photo</td>
			<td><form:input type="file" path="photo" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
			<td><input type="reset" value="Reset" /></td>
		</tr>
	</table>
</form:form>