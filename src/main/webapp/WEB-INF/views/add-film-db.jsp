<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	New Film:
	<form method="POST" action="AddFilmServlet">
		<fieldset class="form-group">
			<label>Title</label> <input name="title" type="text" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Description</label> <input name="description" type="text" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Release year</label> <input name="release_year" type="number" value="1900" step="1" min="0" max="2100" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Duration</label> <input name="duration" type="number" value="0" step="1" min="0" max="1000" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Price</label> <input name="price" type="number" value="0" step="0.01" min="0" placeholder="0,00" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Special features</label> <input name="special_features" type="text" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Average rating</label> <input name="average_rating" type="range" min="0" max="10" step="0.1" class="form-control" /> <BR />
		</fieldset>
		<input name="addMovie" type="submit" class="btn btn-success" value="Add" />
		<input name="cancelMovie" type="submit" class="btn btn-success" value="Cancel"/>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>