<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Question 2</title>
    <style>
        body { font-family: sans-serif; }
        .container { max-width: 600px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
        .stats { margin-top: 20px; padding: 10px; background-color: #f1f1f1; border-left: 5px solid #007BFF; }
    </style>
</head>
<body>
<div class="container">
    <h2>Have you accepted the challenge to climb to the captains bridge?</h2>
    <form action="q2" method="post">
        <label>
            <input type="radio" name="answer" value="go_to_bridge" required> Climb up to the bridge
        </label><br>
        <label>
            <input type="radio" name="answer" value="decline_bridge"> Refuse to go up to the bridge
        </label><br><br>
        <button type="submit">ANSWER</button>
    </form>
    <div class="stats">
        <h3>Statistics</h3>
        <p>IP Address: <%= request.getRemoteAddr() %></p>
        <p>Nicknames: <c:out value="${player.name}" /></p>
        <p>Game counter: <c:out value="${player.getGameCount()}" /></p>
    </div>
</div>
</body>
</html>