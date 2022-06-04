<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h3>Edit Note</h3>
        <form method="POST" action="notes">
            <div>
                <label for="title">Title:</label>
                <input type="text" name="title" id="title" required="true" value="${title}">
            </div><br>
            <div>
                 <label for="content">Contents:</label>
                <textarea rows="10" cols="20" name="content" id="content">${content}</textarea>
            </div><br>
            <input type="submit" value="save">
        </form>
    </body>
</html>
