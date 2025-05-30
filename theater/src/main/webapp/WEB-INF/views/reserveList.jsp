<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reserveList Page</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }

    h2 {
        text-align: center;
        color: #2c3e50;
    }

    table {
        width: 90%;
        margin: 30px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 14px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #3498db;
        color: white;
    }

    tr:hover {
        background-color: #f0f8ff;
    }

    a {
        color: #3498db;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    .home-link {
        display: block;
        width: fit-content;
        margin: 20px auto;
        padding: 10px 20px;
        background-color: #3498db;
        color: white;
        border-radius: 5px;
        text-align: center;
        transition: background-color 0.3s;
    }

    .home-link:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>
     <h2>실시간 예매 현황</h2>
    <table>
        <tr>
            <th>예매 번호</th>
            <!-- <th>회원 ID</th> -->
            <th>공연 제목</th>
            <th>예매 일자</th>
            <th>예매</th>
        </tr>
        <c:forEach var="r" items="${reserveList}">
            <tr>
                <td>${r.rid}</td>
                <%-- <td>${r.mid}</td> --%>
                <td>${r.showTitle}</td>
                <td>${r.rdate}</td>
                <td><a href="/reserveForm?pid=${r.pid}">예매하러 가기</a></td>
            </tr>
        </c:forEach>
    </table>

    <a href="/" class="home-link">홈으로 돌아가기</a>
</body>
</html>