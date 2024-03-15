<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="js/form_validation.js"></script>
<h1 style="text-align: center; color: blue;">Edit Employee</h1>
<form:form modelAttribute="emp" onsubmit="return validate(this)">
<%-- <p style="color: red; text-align: center;">
		<form:errors path="*"></form:errors>
	</p> --%>
	<table align="center">
		<tr>
			<th>Employee No</th>
			<td><form:input path="empno" readOnly="true"/></td>
		</tr>
		<tr>
			<th>Employee Name</th>
			<td><form:input path="ename" /><form:errors path="ename" cssStyle="color:red"/><span id="enameErr" style="color: red;"></span></td>
		</tr>
		<tr>
			<th>Designation</th>
			<td><form:input path="job" /><form:errors path="job" cssStyle="color:red"/><span id="jobErr" style="color: red;"></span></td>
		</tr>
		<tr>
			<th>Dept No.</th>
			<td><form:input path="deptno" /><form:errors path="deptno" cssStyle="color:red"/><span id="deptnoErr" style="color: red;"></span></td>
		</tr>
		<tr>
			<th>Salary</th>
			<td><form:input path="sal" /><form:errors path="sal" cssStyle="color:red"/><span id="salErr" style="color: red;"></span></td>
		</tr>
		<tr>
			<td><form:hidden path="vflag" /></td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit">Edit Employee</button>
				<button type="reset">Cancel</button></td>
		</tr>
	</table>
</form:form>