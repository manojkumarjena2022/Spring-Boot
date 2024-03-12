<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="text-align: center; color: blue;">Edit Employee</h1>
<form:form modelAttribute="emp">
	<table align="center">
		<tr>
			<th>Employee No</th>
			<td><form:input path="empno" /></td>
		</tr>
		<tr>
			<th>Employee Name</th>
			<td><form:input path="ename" /></td>
		</tr>
		<tr>
			<th>Designation</th>
			<td><form:input path="job" /></td>
		</tr>
		<tr>
			<th>Dept No.</th>
			<td><form:input path="deptno" /></td>
		</tr>
		<tr>
			<th>Salary</th>
			<td><form:input path="sal" /></td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit">Edit Employee</button>
				<button type="reset">Cancel</button></td>
		</tr>
	</table>
</form:form>