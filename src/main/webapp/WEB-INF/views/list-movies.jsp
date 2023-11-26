<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${name}</H1>


	<table class="table table-striped">
		<caption>Your movies are</caption>
		<thead>
			<th>Description</th>
			<th>Category</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${movies}" var="film">
				<tr>
					<td>${film.name}</td>
					<td>${film.category}</td>
					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="DeleteFilmServlet?film=${film.name}&category=${film.category}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="AddFilmServlet">Add New Film</a>
</div>

<%@ include file="../common/footer.jspf"%>