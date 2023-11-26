<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	New Actor:
	<form method="POST" action="AddActorServlet">
		<fieldset class="form-group">
			<label>First name</label> <input name="firstName" type="text" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Last name</label> <input name="lastName" type="text" class="form-control" /> <BR />
		</fieldset>
		<input name="addActor" type="submit" class="btn btn-success" value="Add" />
		<input name="cancelActor" type="submit" class="btn btn-success" value="Cancel"/>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>