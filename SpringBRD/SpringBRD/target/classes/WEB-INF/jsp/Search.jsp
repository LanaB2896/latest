<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>helloa</h1>
<form:form action="search" modelAttribute="search" method="post">
Search by 
<form:input path="customerCode" />
<input type="submit" value = Search/>



<table>
			<tr><th>Customer Code</th>
				<th>Customer Name</th>
				<th>Customer Address</th>
				<th>Customer Pincode</th>
				<th>Customer E-mail</th>
				<th>Customer Number</th>
				<th>Registration Date</th>
				<th>Created By</th>
				<th>Modified Date</th>
		
			</tr>

		
				<tr>
				<th>${search.customerCode}</th> 
					<th>${search.customerName}</th>
					<th>${search.customerAddress}</th>
					<th>${search.customerPincode}</th>
					<th>${search.customerEmail}</th>
					<th>${search.customerNumber}</th>
					<th>${search.registrationDate}</th>
					<th>${search.createdBy}</th>
					<th>${search.modifiedDate}</th>
				</tr>
	
		</table>

</form:form>






</body>
</html>