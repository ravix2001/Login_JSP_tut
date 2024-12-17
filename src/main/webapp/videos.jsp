<%--
  Created by IntelliJ IDEA.
  User: Ravi
  Date: 12/13/2024
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Videos</title>
</head>
<body>

    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");     //for Http 1.1

        response.setHeader("Pragma","no-cache");        //for Http 1.0

        response.setHeader("Expires","0");      //for Proxies

        if(session.getAttribute("username")==null){
            response.sendRedirect("index.jsp");
        }
    %>

    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" multiple>
        <input type="submit">
    </form>

    <ul>
        <li>Video 1</li>
        <iframe width="560" height="315" src="https://www.youtube.com/embed/LXb3EKWsInQ?si=Y6C-FwoR75qK8gEh" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
        <li>Video 2</li>
        <li>Video 3</li>
        <li>Video 4</li>

    </ul>
</body>
</html>
