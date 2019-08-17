<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Form</title>
</head>
<body>
  <h1>Order Form</h1>
  <form:form action="confirmorder.obj" modelAttribute="order">
      <table border="1" >
    
         <tr>
            <td>Customer Name</td>
            <td><form:input path="custName"/> 
            </td>
         </tr>
         <tr>
            <td>Customer Mobile</td>
            <td><form:input path="custMobile"/> 
               </td>
         </tr>
         <tr>
            <td>Item Id</td>
            <td><form:input path="itemId" readonly="true" /> 
               </td>
         </tr>
         <tr>
            <td>Quantity</td>
            <td><form:input path="quantity" readonly="true"/> 
             </td>
         </tr>
            <td colspan="2"><input type="submit" value="Place Order"> </td>
         </tr>
         <tr>
            <td colspan="2"><a href ="goHome.obj">Go Home</a></td>
         </tr>
   </table>
  </form:form>
</body>
</html>