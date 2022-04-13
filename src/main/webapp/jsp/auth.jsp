<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
    <form method="post" action="check-auth">
        <label for="login">Login</label>
        <input id="login" type="text" name="login" placeholder="Enter your login!"/>

        <label for="password">Password</label>
        <input id="password" type="password" name="password" placeholder="Enter your password!"/>

        <input type="submit" value="Submit!"/>
    </form>
</body>
</html>
