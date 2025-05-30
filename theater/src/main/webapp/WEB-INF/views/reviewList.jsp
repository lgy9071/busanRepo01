<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reviewList Page</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f5f7fa;
        padding: 40px;
    }

    h2 {
        text-align: center;
        color: #2c3e50;
    }

    a {
        display: inline-block;
        margin-bottom: 20px;
        padding: 10px 16px;
        background-color: #3498db;
        color: white;
        text-decoration: none;
        border-radius: 6px;
        transition: background-color 0.3s ease;
    }

    a:hover {
        background-color: #2980b9;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        border-radius: 8px;
        overflow: hidden;
    }

    th, td {
        padding: 14px 18px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #2c3e50;
        color: white;
    }

    tr:hover {
        background-color: #f0f8ff;
    }
</style>
</head>
<body>
     <h2>공연 후기</h2>
    <a href="/reviewForm">후기 작성</a>
    <table>
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>공연 제목</th>
            <th>내용</th>
            <th>작성일</th>
        </tr>
        <c:forEach var="r" items="${reviewList}">
            <tr>
                <td>${r.reid}</td>
                <td>${r.mid}</td>
                <td>${r.showTitle}</td> 
                <td>${r.comment}</td>
                <td>${r.regDate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>