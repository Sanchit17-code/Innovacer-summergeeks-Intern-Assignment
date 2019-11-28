<%@page import="tasks.Driver"%>
<html>

<body>

<%= tasks.Driver.func1( request.getParameter("name"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("hname"), request.getParameter("hphone"), request.getParameter("hemail")) %>
<br></br>

<a href="http://localhost:8080/Innovacer/Details.html"> Go Back </a>
<br></br>

</body>

</html>

