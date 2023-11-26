<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	New Category:
	<form method="POST" action="AddCategoryServlet">
		<fieldset class="form-group">
			<label>Name category</label> <input name="name" type="text" class="form-control" /> <BR />
		</fieldset>
		<input name="addCategory" type="submit" class="btn btn-success" value="Add" />
		<input name="cancelCategory" type="submit" class="btn btn-success" value="Cancel"/>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>