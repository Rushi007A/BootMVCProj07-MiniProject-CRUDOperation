<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<c:choose>
<c:when test="${!Empty empList}">
<h1 style="color:red;text-align:center">Employee Report</h1>
<table border="1" align="center" bgcolor="cyan">
<tr style="color:red">
<th>empno</th>
<th>emp name</th>
<th>job</th>
<th>salary</th>
<th>deptno</th>
</tr>
<c:forEach var="emp" items="${empList }">
<tr style="color:blue">
<td>${emp.empno }</td>
<td>${emp.empname}</td>
<td>${emp.job }</td>
<td>${emp.salary }</td>
<td>${emp.deptno }</td>

<td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.png" width="70px" height="50px"></a>
<a href="emp_delete?no=${emp.empno }"><img src="images/delete.png" width="70px" height="50px"></a></td>

</tr>
<h2 style="color:red; text-align:center">${resultMsg }</h2>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">Employee Not found</h1>
</c:otherwise>
</c:choose>

<center>
<a href='emp_add'><img src="images/add.png" width="70px" height="50px">Add Employee</a>&nbsp;&nbsp;&nbsp;
<a href="./"><img src="images/home.jpeg" width="70px" height="50px" >Home</a>

</center>