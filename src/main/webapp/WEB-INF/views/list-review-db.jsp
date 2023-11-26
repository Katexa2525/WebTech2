<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${name} to REVIEWS</H1>
	
	<table class="table table-striped">
		<thead>
			<th>ID film</th>
			<th>Review</th>
		</thead>
		<tbody>
			<c:forEach items="${reviews}" var="review">
				<tr>
					<td>${review.movie_id}</td>
					<td>${review.review}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@ include file="../common/footer.jspf"%>