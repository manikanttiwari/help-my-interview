<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view jobs</title>


</head>
<body>
	<table border="1">
            <thead>
                <tr>
                    <th>Company Name</th>
                    <th>Company Tenure</th>
                    <th>Designation</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="company" items="${list}">
                <tr>
                    <td><c:out value="${company.getCompanyName()}"  /></td>
                    <td><c:out value="${company.getCompanyTenure()}" /></td>
                    <td><c:out value="${company.getJobs()}" /></td>
                    <td><button id="${company.getId() }"  name="apply" value="${company.getId() }" onclick="changevalue(${company.getId() })" >Apply</button></td>
		            
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <script>
function changevalue(value){
	console.log("")
    //THIS IS AJAX CODING
    console.log("executed");
    var xmlhttp;
    if (window.XMLHttpRequest){
        //Code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }else{
        //Code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
 
    xmlhttp.onreadystatechange = function(){
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            document.getElementById("value").value = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","/help-my-interview/ApplyServlet?apply="+value); 
    xmlhttp.send();
}
</script>
</body>
</html>