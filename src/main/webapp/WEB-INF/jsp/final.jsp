<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>End of the game</title>
    <style>
        body { font-family: sans-serif; }
        .container { max-width: 600px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
    </style>
</head>
<body>
<div class="container">
    <h2>Result</h2>
    <p><c:out value="${message}" /></p>
    <p>Do you want to play again?</p>
    <a href="index.jsp">Start over</a>
</div>
</body>
</html>