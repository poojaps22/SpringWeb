<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
 Welcome to HomePage
 </h1>
 <h2> 
 Enter Email
  </h2>
  <form action="doProcessForm" method="post">
  	<!--  Username <input type="text" name="username"><br/> -->
  	Email <input type="text" name="email"><br/>
  	
  	<div>
  		Female <input type="radio" id="female" name="gender" value="female" checked>
  	</div>
  	
  	<div>
  		Male <input type="radio" id="male" name="gender" value="male">
  	</div>
  	
  	<input type="submit">
  </form>
</body>
</html>