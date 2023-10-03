<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="study.servlet.domain.member.Member" %>
<%@ page import="study.servlet.domain.member.MemberRepository" %>
<%
    // JSP 파일도 결국 서블릿으로 변환되기 때문에 request, response 객체는 import 없이 사용할 수 있다.
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Save</title>
</head>
<body>
성공
    <ul>
        <li>id=<%=member.getId()%></li>
        <li>username=<%=member.getUsername()%></li>
        <li>age=<%=member.getAge()%></li>
    </ul>
    <a href="/index.html">메인</a>
</body>
</html>