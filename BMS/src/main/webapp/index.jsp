<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banking Application Home</title>
    <style>
    body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}
body {
             background-image: url("bank.webp");
             background-repeat: no-repeat;
             background-color:white;
             background-size: cover;
}
.container {
    width: 80%;
    margin: auto;
    overflow: hidden;
}

header {
    
    padding-top: 30px;
    min-height: 70px;
    border-bottom: #e8491d 3px solid;
}

header a {
    color: #ffffff;
    text-decoration: none;
    text-transform: uppercase;
    font-size: 16px;
}

header ul {
    padding: 0; 
    list-style: none;
}

header li {
    float: left;
    display: inline;
    padding: 0 20px 0 20px;
}

header nav {
    float: right;
    margin-top: 10px;
}

header .highlight, header .current a {
    color: #e8491d;
    font-weight: bold;
}

header a:hover {
    color: #cccccc;
}

main {
    padding: 20px;
}

main section {
    background: #ffffff;
    padding: 20px;
    margin: 20px 0;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

main section h2 {
    margin-top: 0;
}

form {
    display: flex;
    flex-direction: column;
}

form label {
    margin: 10px 0 5px 0;
}

form input {
    padding: 10px;
    margin: 5px 0 10px 0;
    border: 1px solid #cccccc;
    border-radius: 5px;
}

form button {
    padding: 10px;
    background: #35424a;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

form button:hover {
    background: #e8491d;
}

footer {
    background: #35424a;
    color: #ffffff;
    text-align: center;
    padding: 10px 0;
    margin-top: 20px;
}
    
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>WELCOME TO OUR BANK</h1>
            <nav>
                <ul>
                    
                    <li><a href="http://localhost:8080/BMS/aboutus.jsp">About Us</a></li>
                    <li><a href="http://localhost:8080/BMS/adminlogin.jsp">Admin Login</a></li>
                    <li><a href="http://localhost:8080/BMS/Customerlogin.jsp">Customer Login</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <main>
       <center><h1 style="font-size: 35px;">
       TRUST BANK
       </h1></center>
       <center>
       <p style="font-size: 24px;">"Discover the difference with TrustBank, where your financial dreams are nurtured with
       <br> innovation, security, and a commitment to exceptional service."
       </p>
       </center>
   
</body>
</html>
    
    