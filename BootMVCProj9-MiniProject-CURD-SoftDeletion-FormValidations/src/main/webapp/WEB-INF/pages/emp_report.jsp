<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${!empty empPages}">
		<table border="1" bgcolor="cyan" align="center">
			<tr>
				<th>Emp No</th>
				<th>Emp Name</th>
				<th>Desg</th>
				<th>Dept No</th>
				<th>Salary</th>
				<th>Operation</th>
			</tr>
			<c:forEach var="emp" items="${empPages.getContent()}">
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
		<p style="text-align: center;">
		<c:if test="${!empPages.isFirst() }">
		[<a href="./emp_report?page=0">First</a>]
		</c:if>
		<c:if test="${!empPages.isLast() }">
		[<a href="./emp_report?page=${empPages.getNumber()+1}">Next</a>]
		</c:if>
		
		<c:forEach begin="1" end="${empPages.getTotalPages()}" step="1" var="i">
		[<a href="./emp_report?page=${i-1}">${i}</a>]
            <%-- [<a href="./emp_report?size=10&page=${i-1}">${i}</a>] --%>
        </c:forEach>
        
        <c:if test="${!empPages.isLast() }">
		[<a href="./emp_report?page=${empPages.getTotalPages()-1}">Last</a>]
		</c:if>
		<c:if test="${!empPages.isFirst() }">
		[<a href="./emp_report?page=${empPages.getNumber()-1}">Previous</a>]
		</c:if>
		</p>
	</c:when>
	<c:otherwise>
		<h1 style="color: red;text-align: center;">Records Not Found</h1>
	</c:otherwise>
</c:choose>
<br>
<blink><h1 style="color: green;text-align: center;">${resultMsg}</h1></blink>
<h1 style="text-align: center;"><a href="insert_employee">Add Employee<img src="images/add.png" width="30px" height="30px"/></a></h1>
<h1 style="text-align: center;"><a href="./">Home<img src="images/home.png" width="30px" height="30px"/></a></h1>

