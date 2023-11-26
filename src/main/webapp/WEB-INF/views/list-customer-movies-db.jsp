<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${name} to MY MOVIES</H1>

	<table class="table table-striped">
		<thead>
			<th>ID </th>
			<th>Title</th>
			<th>Description</th>
			<th>Price</th>
			<th>Date</th>
		</thead>
		<tbody>
			<c:forEach items="${movies}" var="film">
				<tr>
					<td>${film.movieId}</td>
					<td>${film.title}</td>
					<td>${film.description}</td>
					<td>${film.price}</td>
					<td>${film.dateBuy}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@ include file="../common/footer.jspf"%>