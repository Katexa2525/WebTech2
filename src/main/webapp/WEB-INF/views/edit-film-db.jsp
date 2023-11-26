<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	Edit Movie:
	<form method="POST" action="EditFilmServlet">
		<input type="hidden" name="movie_id" value="${film.movie_id}" />
		<fieldset class="form-group">
			<label>Title</label> <input name="title" type="text" class="form-control" value="${film.title}" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Description</label> <input name="description" type="text" class="form-control" value="${film.description}"/> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Release year</label> <input name="release_year" type="number" step="1" min="0" max="2100" class="form-control" value="${film.release_year}"/> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Duration</label> <input name="duration" type="number" step="1" min="0" max="1000" class="form-control" value="${film.duration}"/> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Price</label> <input name="price" type="number" step="0.01" min="0" placeholder="0,00" class="form-control" value="${film.price}"/> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Special features</label> <input name="special_features" type="text" class="form-control" value="${film.special_features}"/> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Average rating</label> <input name="average_rating" type="range" min="0" max="10" step="0.1" class="form-control" value="${film.average_rating}"/>
			<BR/>
		</fieldset>
		<input name="saveMovie" type="submit" class="btn btn-success" value="Save" />
		<input name="cancelMovie" type="submit" class="btn btn-success" value="Cancel"/>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>