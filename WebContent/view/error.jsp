<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_login.jspf" %> 


<div class="container">
 
 	Message:
<%=exception.getMessage()%>
<p>
Issue has been created and notified to developer/administrator.....
</p>

 
 </div>



<%@include file="/common/footer.jspf" %>

