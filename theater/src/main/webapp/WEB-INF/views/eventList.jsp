<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 목록 page</title>
<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
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

/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #4CAF50;
    color: white;
}

a {
    color: #4CAF50;
    text-decoration: none;
    font-size: 16px;
}

a:hover {
    text-decoration: underline;
    color: #45a049;
}

/* 링크 스타일 */
br {
    margin-top: 20px;
    text-align: center;
}

a[href="/"] {
    font-size: 16px;
    display: inline-block;
    margin-top: 20px;
    text-align: center;
    color: #005f99;
}

a[href="/"]:hover {
    text-decoration: underline;
    color: #003d66;
}
</style>
</head>
<body>

<div class="container">
    <h2>이벤트 목록</h2>

    <table>
        <tr>
            <th>이벤트 제목</th>
        </tr>
        <c:forEach var="event" items="${list}">
            <tr>
                <td>
                    <a href="/eventDetail?eno=${event.eno}">${event.title}</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="/">메인 페이지로 이동</a>
</div>
</body>
</html>