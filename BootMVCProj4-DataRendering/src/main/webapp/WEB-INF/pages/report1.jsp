<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color: red; text-align: center">Report1 Page</h1>
<h5 style="color: blue;">Reading Array,Collection Values</h5>
<b>Nick Names : </b>
<br>
<c:forEach var="name" items="${ nickNameArray}">${name}<br>
</c:forEach>

<br>
<b>Mobile Nos : </b>
<br>
<c:forEach var="mobile" items="${ mobileNosSet}">${mobile}<br>
</c:forEach>

<br>
<b>Courses : </b>
<br>
<c:forEach var="course" items="${ courseList}">${course}<br>
</c:forEach>

<br>
<b>Ids : </b>
<br>
<c:forEach var="id" items="${ idsMap}">${id.key} : ${id.value}<br>
</c:forEach>