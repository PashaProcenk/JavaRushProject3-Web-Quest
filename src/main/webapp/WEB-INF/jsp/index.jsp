<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web Quest</title>
    <style>
        body { font-family: sans-serif; }
        .container { max-width: 600px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
        .form-group { margin-bottom: 15px; }
    </style>
</head>
<body>
<div class="container">
    <h2>Welcome to the quest!</h2>
    <p>You wake up on the spaceship. It looks like you lost your memory. The only thing you remember is your name. Enter it to get started.</p>
    <form action="start" method="post">
        <div class="form-group">
            <label for="playerName">Your name:</label>
            <input type="text" id="playerName" name="playerName" required>
        </div>
        <button type="submit">Start</button>
    </form>
</div>
</body>
</html>