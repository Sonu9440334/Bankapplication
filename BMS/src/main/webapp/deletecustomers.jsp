<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Customer</title>
    <style>
        .form-container {
            width: 50%;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .form-container h2 {
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .form-group label {
            width: 30%;
        }
        .form-group input {
            width: 65%;
            padding: 6px;
            box-sizing: border-box;
        }
        .submit-button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #ff4d4d;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        body {
             background-image: url("bank.webp");
             background-repeat: no-repeat;
             background-color: white;
             background-size: cover;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Delete Customer</h2>
        <form action="closecustomeraccount" method="post">
            <div class="form-group">
                <label for="accountNumber">Account Number:</label>
                <input type="text" id="accountNumber" name="accountNumber" required>
            </div>
            <button type="submit" class="submit-button">Delete</button>
        </form>
    </div>
</body>
</html>
