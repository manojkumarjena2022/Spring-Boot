<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Marriage Seeker Profiles</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Marriage Seeker Profiles</h2>
    <c:choose>
        <c:when test="${!empty seekerInfo}">
            <table>
                <tr>
                    <th>Profile Id</th>
                    <th>Profile Name</th>
                    <th>Gender</th>
                    <th>Resume</th>
                    <th>Resume Link2</th>
                    <th>Photo</th>
                </tr>
                <c:forEach items="${seekerInfo}" var="seeker">
                    <tr>
                        <td>${seeker.profileId}</td>
                        <td>${seeker.profileName}</td>
                        <td>${seeker.gender}</td>
                        <%-- <td><a href="${seeker.resumePath}" target="_blank">Download Resume</a></td> --%>
                        <td><a href="download?file=${seeker.resumePath}" target="_blank">Download Resume</a></td>
                        <td><a href="download?file=${seeker.resumePath}" target="_blank">${fn:substringAfter(seeker.resumePath,'D:/store/') }</a></td>
                        <td><img src="${seeker.photoPath}" alt="Photo" style="width:100px;height:auto;"></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>No profiles available.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
