<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <style>
        body {
            background-image: url("bank.webp");
            background-repeat: no-repeat;
            background-color: white;
            background-size: cover;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        header {
            background: #333;
            color: #fff;
            padding-top: 30px;
            min-height: 70px;
            border-bottom: #77a6d0 3px solid;
        }
        header a, .button {
            color: #fff;
            text-decoration: none;
            text-transform: uppercase;
            font-size: 16px;
        }
        header ul {
            padding: 0;
            list-style: none;
        }
        header li {
            float: right;
            display: inline;
            padding: 0 20px 0 20px;
        }
        .main-content {
            padding: 20px;
            background: #fff;
            margin-top: 20px;
            border: 1px solid #ddd;
        }
        .main-content h2 {
            margin-top: 0;
        }
        .account-details {
            margin-bottom: 20px;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
        }
        .button:hover {
            background-color: #45a049;
        }
        .logout {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Trust Bank</h1>
            <ul>
                <li><a href="index.jsp" class="button">Logout</a></li>
            </ul>
        </div>
    </header>
    <div class="container">
        <div class="main-content">
            <h2>Customer Dashboard</h2>
            <div class="account-details">
                <h3>Account Details</h3>
                <p>Account Number: <span id="accountNumber"><%= request.getAttribute("accountNumber") %></span></p>
                <p>Account Type: <span id="accountType"><%= request.getAttribute("accountType") %></span></p>
                <p>Balance: <span id="balance"><%= request.getAttribute("balance") %></span></p>
             
            </div>
            <div class="buttons">
                <a href="deposit.jsp" class="button">Deposit</a>
                <a href="withdraw.jsp" class="button">Withdraw</a>
                <a href="viewTransactions" class="button">View Transactions</a>
                <a href="closecustomeraccount.jsp" class="button">Close Account</a>
            </div>
        </div>
    </div>
</body>
</html>
