<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Notes</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h3>Notes</h3>       
            <c:forEach items="${notes}" varStatus="loop" var="i">
                <a href="notes?index=${loop.index}"><br>
                    ${i.title}
                </a>
            </c:forEach>
         <c:if test="${empty notes}">
            <p>There are no Notes added<br> To add some click the button given below</p>
        </c:if>
            <br>
            <a href="notes?edit=true">Add notes</a>
    </body>
</html>
