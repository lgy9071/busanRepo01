<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원 List Page</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* 컨테이너 */
.container {
    width: 80%;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* 헤더 스타일 */
h2 {
    font-size: 24px;
    color: #333;
    margin-bottom: 20px;
    text-align: center;
}

/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

th, td {
    padding: 12px;
    text-align: center;
    border: 1px solid #ddd;
}

/* 테이블 헤더 스타일 */
th {
    background-color: #f4f4f9;
    color: #333;
    font-weight: bold;
}

/* 테이블 바디 스타일 */
td {
    background-color: #fff;
    color: #333;
}

/* 링크 스타일 */
a {
    color: #005f99;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

/* 메인 페이지 링크 스타일 */
a[href='/'] {
    display: inline-block;
    margin-top: 20px;
    background-color: #005f99;
    color: #fff;
    padding: 10px 15px;
    border-radius: 4px;
    text-align: center;
    text-decoration: none;
}

a[href='/']:hover {
    background-color: #004080;
}
</style>
</head>
<div class="container">
    <h2>회원 목록</h2>
    <hr>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Pw</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td><a href="/detail?id=${member.id}">${member.id}</a></td>
                    <td>${member.pw}</td>
                    <td>${member.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/">메인 페이지로 이동</a>
</div>

</html>