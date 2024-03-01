<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color: red; text-align: center">Report Page</h1>
<h5 style="color: blue;">Reading List Of Model Objects</h5>
<b>Employees data :</b>
<br>
<table border="1" align="center">
	<tr>
		<th>EID</th>
		<th>ENAME</th>
		<th>DESIGNATION</th>
		<th>SALARY</th>
	</tr>
	<c:forEach var="employee" items="${ employeeList}">
		<tr>
			<th>${employee.eid}</th>
			<th>${employee.ename}</th>
			<th>${employee.desg}</th>
			<th>${employee.salary}</th>
		</tr>
	</c:forEach>
</table>