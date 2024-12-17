<%--
  Created by IntelliJ IDEA.
  User: Ravi
  Date: 12/13/2024
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");     //for Http 1.1

        response.setHeader("Pragma", "no-cache");        //for Http 1.0 (older version)

        response.setHeader("Expires", "0");      //for Proxies

        if(session.getAttribute("username")==null){
            response.sendRedirect("index.jsp");
        }
    %>
    <h1>Welcome ${username}</h1>
    <br>
    <a href="videos.jsp">Videos</a>

    <form action="logout">
        <input type="submit" value="Logout">
    </form>

</body>
</html>
