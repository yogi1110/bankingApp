<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>balence</title>
    <style>
    .form{
        background-color: aquamarine;
        height: 250px;
        width: 450px;
        font-weight: 250px;
        border: aquamarine solid 1px;
        border-radius: 28px;
        transform: translate(250px);
    }
    .lable{
        font-size: 35px;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        text-align: center;
        position: absolute;
        transform: translate(120px,20px);
    }
    .table{
font-size: 50px;
font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
    text-align: center;
    
    color:black;
    font-size:75px;
    font-family:impact;
    transform: translate(70px,70px);
    }
    </style>
</head>
<body>
<%
HttpSession hs=request.getSession();
int ba=(Integer)hs.getAttribute("BALENCE");

%>
    <form class="form" >
        <label class="lable"> your Balence is</label>
        <table class="table">
        <tr><td>
        Rs.<%out.println(ba); %>/-
       </tr></td> </table>
    </form> 
</body>
</html>