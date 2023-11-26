<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${name} to Category</H1>

	<a class="btn btn-success" href="AddCategoryServlet">Add New Category</a>

	<table class="table table-striped">
		<thead>
			<th>ID category</th>
			<th>Name</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${categoryes}" var="category">
				<tr>
					<td>${category.categoryId}</td>
					<td>${category.name}</td>
					<td>&nbsp;&nbsp;
						<a class="btn btn-danger"	href="DeleteCategoryServlet?category=${category.categoryId}">Delete</a>
					</td>
					<td>&nbsp;&nbsp;
						<a class="btn btn-danger"	href="EditCategoryServlet?category=${category.categoryId}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="AddCategoryServlet">Add New Category</a>
</div>

<%@ include file="../common/footer.jspf"%>