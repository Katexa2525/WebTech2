<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${name} to Actor</H1>

	<a class="btn btn-success" href="AddActorServlet">Add New Actor</a>

	<table class="table table-striped">
		<thead>
			<th>ID actor</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${actors}" var="actor">
				<tr>
					<td>${actor.actorId}</td>
					<td>${actorme.firstNa}</td>
					<td>${actor.lastName}</td>
					<td>&nbsp;&nbsp;
						<a class="btn btn-danger"	href="DeleteActorServlet?actor=${actor.actorId}">Delete</a>
					</td>
					<td>&nbsp;&nbsp;
						<a class="btn btn-danger"	href="EditActorServlet?actor=${actor.actorId}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="AddActorServlet">Add New Actor</a>
</div>

<%@ include file="../common/footer.jspf"%>