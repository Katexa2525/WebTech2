<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	Edit Category:
	<form method="POST" action="EditCategoryServlet">
		<input type="hidden" name="categoryId" value="${category.categoryId}" />
		<fieldset class="form-group">
			<label>Name category</label> <input name="name" type="text" class="form-control" value="${category.name}"/> <BR />
		</fieldset>
		<input name="saveCategory" type="submit" class="btn btn-success" value="Save" />
		<input name="cancelCategory" type="submit" class="btn btn-success" value="Cancel"/>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>