<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 detail page</title>
<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: flex-start;
    min-height: 100vh;
}

/* 컨테이너 스타일 */
.container {
    width: 80%;
    max-width: 800px;
    margin: 20px auto;
    padding: 30px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* 제목 스타일 */
h2 {
    font-size: 24px;
    color: #333;
    text-align: center;
    margin-bottom: 20px;
}

/* 이벤트 정보 스타일 */
h3 {
    font-size: 22px;
    color: #4CAF50;
}

p {
    font-size: 16px;
    line-height: 1.6;
    color: #555;
    margin-bottom: 20px;
}

/* 버튼 스타일 */
button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    font-size: 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #45a049;
}

/* 메시지 스타일 */
p.style-blue {
    color: #007BFF;
}

/* 구분선 */
hr {
    margin-bottom: 20px;
    border: 1px solid #ddd;
}

/* 링크 스타일 */
a {
    color: #005f99;
    text-decoration: none;
    font-size: 16px;
}

a:hover {
    text-decoration: underline;
    color: #003d66;
}
</style>
</head>
<body>

<div class="container">
    <h2>이벤트 참여하기</h2>
    <hr>

    <h3>${event.title}</h3>
    <p>${event.content}</p>

    <hr>
    <form action="/submitEntry" method="POST">
        <input type="hidden" name="eno" value="${event.eno}">
        <button type="submit">응모하기</button>
    </form>

    <c:if test="${not empty param.msg}">
        <p class="style-blue">${param.msg}</p>
    </c:if>

    <br>
    <a href="/eventList">홈으로</a>
</div>
</body>
</html>