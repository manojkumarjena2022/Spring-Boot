<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="text-align: center; color: blue;">Register Customer</h1>
<form:form action="register_customer" modelAttribute="cust" name="frm">
	<table align="center">
		<tr>
			<th>Customer Name</th>
			<td><form:input path="cname" /></td>
		</tr>
		<tr>
			<th>Gender</th>
			<td><form:radiobutton path="gender" value="Male" label="Male" />
				<form:radiobutton path="gender" value="Female" label="Female" /></td>
		</tr>
		<tr>
			<th>Select Country</th>
			<td><form:select items="${countriesInfo}" path="country" /></td>
		</tr>
		<tr>
			<th>Select Known Languages</th>
			<td><form:select items="${languageInfo}" multiple="multiple"
					path="languages" /></td>
		</tr>
		<tr>
			<th>Hobbies Info</th>
			<td><form:checkboxes items="${hobbiesInfo}" path="hobbies" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
			<td><input type="reset" value="Reset" /></td>
		</tr>
	</table>
</form:form>

