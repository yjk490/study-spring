<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- form 태그의 action에 슬래시(/)가 없으면 상대경로 사용, [현재 URL이 속한 경로 + /save] -->
    <form action="save" method="post">
        username: <input type="text" name="username" />
        age: <input type="text" name="age" />
        <button type="submit">전송</button>
    </form>
</body>
</html>