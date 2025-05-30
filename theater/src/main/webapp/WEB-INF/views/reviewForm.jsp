<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reviewFrom Page</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 40px;
    }

    h2 {
        text-align: center;
        color: #2c3e50;
    }

    form {
        width: 500px;
        margin: 0 auto;
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-top: 15px;
        font-weight: bold;
        color: #333;
    }

    input[type="number"],
    textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    textarea {
        resize: vertical;
    }

    input[type="submit"] {
        margin-top: 20px;
        width: 100%;
        padding: 12px;
        background-color: #3498db;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>
    <h2>공연 후기 작성</h2>
    <form action="/reviewInsert" method="post">
        <input type="hidden" name="pid" value="${performance.pid}">
        <label>별점 (1~5):</label>
        <input type="number" name="rating" min="1" max="5" required>
        <label>내용:</label>
        <textarea name="rcomment" rows="5" cols="40" placeholder="후기를 입력해주세요." required></textarea>
        <input type="submit" value="등록">
    </form>
</body>
</html>