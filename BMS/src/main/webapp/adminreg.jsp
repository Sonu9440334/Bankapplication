<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Customer</title>
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
        .form-group input, .form-group select {
            width: 65%;
            padding: 6px;
            box-sizing: border-box;
        }
        .form-group input[type="radio"] {
            width: auto;
            margin-right: 5px;
        }
        .form-group .radio-container {
            width: 65%;
            display: flex;
            align-items: center;
        }
        .form-group .select-container {
            width: 65%;
            display: flex;
            align-items: center;
        }
        .form-group select {
            flex: 1;
            margin-left: 10px;
        }
        .submit-button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
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
        <h2>Add Customers</h2>
        <form action="adminreg" method="post">
            <div class="form-group">
                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullName" required>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
            </div>
            <div class="form-group">
                <label for="mobileNumber">Mobile Number:</label>
                <input type="text" id="mobileNumber" name="mobileNumber" pattern="\d{10}" required>
            </div>
            <div class="form-group">
                <label for="emailId">Email ID:</label>
                <input type="email" id="emailId" name="emailId" pattern="^[\\w-\\.]+@gmail\\.com$" required>
            </div>
            <div class="form-group">
                <label for="accountType">Account Type:</label>
                <div class="radio-container">
                    <input type="radio" id="saving" name="accountType" value="Saving" required>
                    <label for="saving" style="margin-right: 10px;">Saving</label>
                    <input type="radio" id="current" name="accountType" value="Current" required>
                    <label for="current">Current</label>
                </div>
            </div>
            <div class="form-group">
                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" required>
            </div>
            <div class="form-group">
                <label for="initialBalance">Initial Balance:</label>
                <input type="text" id="initialBalance" name="initialBalance" required>
            </div>
            <div class="form-group">
                <label for="idProofType">ID Proof Type:</label>
                <div class="select-container">
                    <select id="idProofType" name="idProofType" required>
                        <option value="">Select ID Type</option>
                        <option value="Aadhar Card">Aadhar Card</option>
                        <option value="PAN Card">PAN Card</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="idProofNumber">ID Proof Number:</label>
                <input type="text" id="idProofNumber" name="idProofNumber" pattern="\d{12}" required>
            </div>
            
            <button type="submit" class="submit-button">Submit</button>
        </form>
    </div>
</body>
</html>
