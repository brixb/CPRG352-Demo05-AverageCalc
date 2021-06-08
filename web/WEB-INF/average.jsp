
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Average Calculator</title>
    </head>
    <body>
        <h1>Average Calculator</h1>
        
        <form method="get" action="average">
            <label>Enter a number:</label>
            <input type="number" name="number" value="">
            <br>
            <input type="submit" value="Find Average">
        </form>
        <form method="get" action="average">
            <input type="submit" value="Reset Average">
            <input type="hidden" name="action" value="reset">
        </form>
        <div>Average: ${average}</div> 
    </body>
</html>
