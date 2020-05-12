<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hey login Success</title>
    <style>
.form{
    align-items: center;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    text-transform: capitalize;
    text-align: center; 
    background-color: rgb(243, 232, 81);
    height: inherit;
    width: 310px;
    border: crimson solid 3px;
    border-radius: 30px;
    position: relative;
    top: 50px;
    left: 40%;
}
#pas{
    font-size: 25px;
    align-content: flex-start;
    border: maroon solid 2px;
    border-radius: 5px;
    background-color: mediumspringgreen;
    color: black;
    height: inherit;
    width: inherit;
    padding: 5px;
     margin-left: 10px;  
     text-decoration: none;
     transition: all 500ms linear; 
}
#pas:hover{

    text-decoration: none;
    position: relative;
    padding: 5px;
    left: 10px;
    font-size: 30px;
    color: red;
    height: inherit;
    width: inherit;
    border: maroon solid 2px;
    border-radius: 30px;
    background-color: rgb(143, 205, 243);
    
}
.mar{
    align-items: center;
    font-family: cursive;
    font-size: 50px;
    color:maroon;
    height: inherit;
    width: 500px;
    margin: 20px;
    border: mediumblue dotted 5px;
    transform: translate(400px);
    }

    </style>
</head>
<body>
<%
HttpSession hs=request.getSession();
String name=(String)hs.getAttribute("NAME");
%>

    <marquee class="mar" behavior="title" direction="text-transform">hey <%out.println(name); %>login success !!!</marquee>
    <form class="form" action="http://localhost:8000/Bankingapp/Homeservlet">
<table class="imr" cellspacing="25px">
    <tr><td><a id="pas" href="updateprofile.html">update profile</a></td></tr>
    <tr><td><a id="pas" href="updatepassword.html">update password</a></td></tr>
    <tr><td><a id="pas" href="transaction.html">amount transfer</a></td></tr>
    <tr><td><a id="pas" href="Balance.jsp">check Balence</a></td></tr>
</table>
    </form>
</body>
</html>