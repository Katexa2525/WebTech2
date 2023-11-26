<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${name} to CUSTOMER</H1>
	
	<a class="btn btn-success" href="AddCustomerServlet">Add New Customer</a>

	<table class="table table-striped">
		<thead>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Discount</th>
			<th>Bonus</th>
			<th>Active</th>
			<th>IsAdmin</th>
			<th colspan="2">Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.customerId}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
					<td>${customer.discount}</td>
					<td>${customer.bonus}</td>
					<td>${customer.active}</td>
					<td>${customer.isAdmin}</td>
					<td>&nbsp;&nbsp;
						<a class="btn btn-danger"	href="DeleteCustomerServlet?customer=${customer.customerId}">Delete</a>
					</td>
					<td>&nbsp;&nbsp;
						<a class="btn btn-danger"	href="EditCustomerServlet?customer=${customer.customerId}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="AddCustomerServlet">Add New Customer</a>
</div>

<%@ include file="../common/footer.jspf"%>