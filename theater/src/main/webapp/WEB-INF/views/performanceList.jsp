<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>performanceList Page</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f9f9f9;
        color: #333;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 80%;
        margin: 0 auto;
        padding: 50px 0;
    }

    h2 {
        text-align: center;
        font-size: 2.5em;
        color: #2c3e50;
        margin-bottom: 40px;
    }

    .performance-item {
        background-color: #fff;
        padding: 20px;
        margin: 20px 0;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .performance-item h3 {
        font-size: 1.8em;
        color: #3498db;
        margin-bottom: 10px;
    }

    .performance-item p {
        font-size: 1.1em;
        color: #555;
        margin-bottom: 15px;
    }

    .performance-item a {
        color: #3498db;
        text-decoration: none;
        font-weight: bold;
    }

    .performance-item a:hover {
        text-decoration: underline;
    }

</style>
</head>
<body>
<div class="container">
    <h2>영화 목록</h2>
    <c:forEach var="p" items="${list}">
        <div class="performance-item">
            <h3>${p.title} (${p.status})</h3>
            <p>${p.description}</p>
            <a href="/performanceDetail?pid=${p.pid}">자세히 보기</a>
        </div>
    </c:forEach>
    <a href = "/">홈으로</a>
</div>
</body>
</html>