<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Transaction.Transaction" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Last 10 Transactions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('bank.webp');
            background-size: cover;
        }
        table {
            width: 80%;
            margin: 50px auto;
            border-collapse: collapse;
            background: white;
            opacity: 0.9;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .container {
            text-align: center;
        }
        .download-btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Last 10 Transactions</h1>
        <table>
            <tr>
                <th>Transaction ID</th>
                <th>Transaction Type</th>
                <th>Amount</th>
                <th>Date</th>
            </tr>
            <%
                List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
                if (transactions != null) {
                    for (Transaction transaction : transactions) {
            %>
                        <tr>
                            <td><%= transaction.getTransactionID() %></td>
                            <td><%= transaction.getTransactionType() %></td>
                            <td><%= transaction.getAmount() %></td>
                            <td><%= transaction.getDate() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">No transactions found.</td>
                </tr>
            <%
                }
            %>
        </table>
        <a href="DownloadTransactionsServlet?accountNo=<%= request.getParameter("accountNo") %>" class="download-btn">Download Transactions</a>
    </div>
</body>
</html>
