<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${name} to MOVIES</H1>
	
	<c:if test="${sessionScope.name != null and sessionScope.isAdmin == 1}">
		<a class="btn btn-success" href="AddFilmServlet">Add New Film</a>
	</c:if>
	
	<table class="table table-striped">
		<thead>
			<th>ID film</th>
			<th>Title</th>
			<th>Description</th>
			<th colspan="2">Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${movies}" var="film">
				<tr>
					<td>${film.movie_id}</td>
					<td>${film.title}</td>
					<td>${film.description}</td>
					
					<c:if test="${sessionScope.name != null and sessionScope.isAdmin == 1}">
						<td>&nbsp;&nbsp;
							<a class="btn btn-danger"	href="DeleteFilmServlet?film=${film.movie_id}">Delete</a>
						</td>
						<td>&nbsp;&nbsp;
							<a class="btn btn-danger"	href="EditFilmServlet?film=${film.movie_id}">Edit</a>
						</td>
					</c:if>
					
					<td>&nbsp;&nbsp;
							<a class="btn btn-danger"	href="ListReviewServlet?film=${film.movie_id}">Review</a>
					</td>
					<td>&nbsp;&nbsp;
							<a class="btn btn-danger"	href="BuyFilmServlet?film=${film.movie_id}">Buy movie</a>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<c:if test="${sessionScope.name != null and sessionScope.isAdmin == 1}">
		<a class="btn btn-success" href="AddFilmServlet">Add New Film</a>
	</c:if>
</div>

<!--  <%@ include file="../common/footer.jspf"%>  -->