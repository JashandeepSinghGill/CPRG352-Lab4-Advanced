<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Notes</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h3>Edit Note</h3>
        <form method="POST" action="notes">
            <div>
                <label for="title">Title:</label>
                <p>${note.title}</p>
            </div><br>
            <div>
                 <label for="content">Contents:</label>
                 <p>${note.content}</p>
            </div><br>
            <a href="notes?edit=true&fromView=true">Edit</a>
        </form>
    </body>
</html>
