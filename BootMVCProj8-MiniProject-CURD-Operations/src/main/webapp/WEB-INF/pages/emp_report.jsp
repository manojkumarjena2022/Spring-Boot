<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${!empty empList}">
		<table border="1" bgcolor="cyan" align="center">
			<tr>
				<th>Emp No</th>
				<th>Emp Name</th>
				<th>Desg</th>
				<th>Dept No</th>
				<th>Salary</th>
				<th>Operation</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.deptno}</td>
					<td>${emp.sal}</td>
					<td><a href="edit_employee?eno=${emp.empno}"> <img
							src="images/edit.png" width="30px" height="30px" />
					</a> <a href="delete_employee?eno=${emp.empno}" onclick="confirm('Do you want to delete this record ?')"><img
							src="images/delete.png" width="30px" height="30px" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red;text-align: center;">Records Not Found</h1>
	</c:otherwise>
</c:choose>
<br>
<blink><h1 style="color: green;text-align: center;">${resultMsg}</h1></blink>
<h1 style="text-align: center;"><a href="insert_employee">Add Employee<img src="images/add.png" width="30px" height="30px"/></a></h1>
<h1 style="text-align: center;"><a href="./">Home<img src="images/home.png" width="30px" height="30px"/></a></h1>

