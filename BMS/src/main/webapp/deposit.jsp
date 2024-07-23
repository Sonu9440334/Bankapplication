<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit Money</title>
    <style>
        body {
             background-image: url("bank.webp");
             background-repeat: no-repeat;
             background-color: white;
             background-size: cover;
        }

        .container {
            width: 50%;
            margin: auto;
            overflow: hidden;
            background: #fff;
            padding: 20px;
            margin-top: 50px;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px #000;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            font-size: 16px;
        }
        .button:hover {
            background-color: #45a049;
        }
        .message {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Deposit Money</h2>
        <form action="deposit" method="post">
            <div class="form-group">
                <label for="accountNumber">Account Number:</label>
                <input type="text" id="accountNumber" name="accountNumber" readonly value="<%= session.getAttribute("accountNumber") %>"> <!-- Value set from session -->
            </div>
            <div class="form-group">
                <label for="depositAmount">Amount to Deposit:</label>
                <input type="number" id="depositAmount" name="depositAmount" min="1" required>
            </div>
            <button type="submit" class="button">Deposit</button>
        </form>
        <div class="message">
            <!-- Success or error message will be displayed here -->
        </div>
    </div>
</body>
</html>
