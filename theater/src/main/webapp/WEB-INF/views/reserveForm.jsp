<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reserveForm Page</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        padding: 0;
        margin: 0;
    }

    .container {
        width: 400px;
        margin: 60px auto;
        padding: 30px;
        background: white;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 25px;
    }

    label {
        font-size: 1.1em;
        color: #333;
        margin-bottom: 8px;
        display: block;
    }

    select {
        width: 100%;
        padding: 10px;
        font-size: 1em;
        border: 1px solid #ccc;
        border-radius: 6px;
        margin-bottom: 20px;
    }

    button {
        width: 100%;
        padding: 12px;
        background-color: #3498db;
        color: white;
        font-size: 1.1em;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    button:hover {
        background-color: #2980b9;
    }

</style>
</head>
<body>
     <div class="container">
        <h2>새 예매</h2>
        <form action="/insertReserve" method="post">
            <label for="pid">공연 선택:</label>
            <select name="pid" id="pid">
                <c:forEach var="p" items="${performanceList}">
                    <option value="${p.pid}" ${p.pid == param.pid ? 'selected' : ''}>${p.title}</option>
                </c:forEach>
            </select>

            <input type="hidden" name="mid" value="${sessionScope.loginId}" />

            <button type="submit">예매하기</button>
        </form>
    </div>
</body>
</html>