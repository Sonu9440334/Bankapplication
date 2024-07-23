<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en"> 

<head> 
	<meta charset="UTF-8"> 
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0"> 
	<style> 
	body {
             background-image: url("bank.webp");
             background-repeat: no-repeat;
          
             background-size: cover;
}
	
		body { 
			margin: 20px; 
			font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
			display: flex; 
			height: 100vh; 
		} 

		.split-container { 
			display: flex; 
			width: 50%; 
			height: 87%; 
			
			
		} 

		.split-left, 
		.split-right { 
			flex: 1; 
			overflow: hidden; 
			text-align: center; 
			transition: all 0.3s; 
			border-radius: 10px; 
			display: flex; 
			flex-direction: column; 
			justify-content: center; 
			align-items: center; 
			margin: 5px; 
		} 

		.split-left { 
			background-color: #3b3a41; 
			color: #ffffff; 
			border: 2px solid rgb(95, 156, 180); 

		} 

		p { 
			line-height: 30px; 
		} 

		.split-right { 
			background-color: #f6f7fa; 
			color: #333333; 
			border: 2px solid grey; 

		} 

		.split-left:hover { 
			background-color: #313532; 
			transform: scale(1.05); 
			border: 3px solid rgb(87, 128, 87); 
		} 

		.split-right:hover { 
			background-color: #cbeaeb; 
			transform: scale(1.05); 
			border: 3px solid rgb(146, 205, 223); 
		} 

		@media (max-width: 768px) { 
			.split-container { 
				flex-direction: column; 
			} 

			.split-left, 
			.split-right { 
				margin: 5px; 
				width: 95%; 
				height: 48vh; 
			} 
			
		} 
		
	</style> 
	
	<title>Custom Split Layout</title> 
	
</head>


<body> 
<button style="height:40px" , "width:20px"><a href="http://localhost:8080/BMS/index.jsp">Back to home</a></button>

	<div class="split-container"> 
		<div class="split-left"> 
			<h1>Money Saving</h1> 
			<p>Saving money in a bank ensures security and earns interest over time, growing your wealth. It's a reliable way to manage finances and plan for future needs.
			</p> 
			<img src="money.jpeg" alt="image" width="300" height="250">
		</div> 
		<div class="split-right"> 
			<h1>Credit / Debit Cards</h1> 
			<p>Credit cards allow you to borrow money up to a certain limit for purchases and payments, with the obligation to pay back with interest if not settled in full each month. 
			</p> 
			<img src="debit.jpeg" alt="image" width="300" height="250">
		</div>
		 
	</div> 
	<aside>
	<img Vertical-alignment="bottom" src="photo1.jpeg" alt="image" width="700" height="400">
	</aside>
	
	
</body> 

</html>
    