<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iogin Page</title>
<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* 컨테이너 스타일 */
.container {
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    width: 300px;
    text-align: center;
}

/* 헤더 스타일 */
h2 {
    color: #333;
    font-size: 24px;
    margin-bottom: 20px;
}

/* 폼 필드 스타일 */
input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
    box-sizing: border-box;
}

button {
    background-color: #005f99;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    width: 100%;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #004080;
}

/* 오류 메시지 스타일 */
p {
    color: red;
    font-size: 14px;
    margin-top: 10px;
}
</style>
</head>
<body>
<div class="container">
    <h2>Login Page</h2>
    <hr>
    <form action="/member/login" method="POST">
        <label for="id">아이디:</label>
        <input type="text" name="id" id="id" placeholder="아이디를 입력하세요" required><br>
        
        <label for="pw">비밀번호:</label>
        <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" required><br>
        
        <button type="submit">로그인하기</button>
    </form>

    <!-- 로그인 실패 시 메시지 표시 -->
    <c:if test="${not empty msg}">
        <p>${msg}</p>
    </c:if>
</div>
</body>
</html>