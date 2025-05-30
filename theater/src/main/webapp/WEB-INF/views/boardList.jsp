<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시판 목록</title>
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

/* 컨테이너 */
.container {
    width: 80%;
    margin: 30px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* 헤더 스타일 */
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
    margin-bottom: 20px;
}

table th, table td {
    padding: 10px;
    text-align: center;
    border: 1px solid #ddd;
}

table th {
    background-color: #4CAF50;
    color: white;
}

table td a {
    color: #005f99;
    text-decoration: none;
}

table td a:hover {
    text-decoration: underline;
}

/* 링크 스타일 */
a {
    color: #005f99;
    text-decoration: none;
    font-size: 16px;
    font-weight: bold;
}

a:hover {
    text-decoration: underline;
    color: #003d66;
}

br {
    margin-bottom: 20px;
}
</style>
</head>
<body>
	
<div class="container">
    <h2>게시글 목록</h2>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
        </tr>
        <c:forEach var="board" items="${list}">
            <tr>
                <td><a href="/boardDetail?bno=${board.bno}">${board.bno}</a></td>
                <td><a href="/boardDetail?bno=${board.bno}">${board.title}</a></td>
                <td><a href="/boardDetail?bno=${board.bno}">${board.writer}</a></td>
            </tr>
        </c:forEach>
       
    </table>
    <a href="/boardWrite">새 글 작성</a><br><br>
    <a href="/">메인 페이지로 이동</a>
</div>

</body>
</html>