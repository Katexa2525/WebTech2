<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	New Customer:
	<form method="POST" action="AddCustomerServlet">
		<fieldset class="form-group">
			<label>Login</label> <input name="firstName" type="text" class="form-control" /> 
			<label>Password</label> <input name="password" type="password" class="form-control" />
			<label>Name</label> <input name="lastName" type="text" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Email</label> <input name="email" type="email" placeholder="example@example.com" class="form-control" /> 
			<label>Address</label> <input name="address" type="text" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Discount</label> <input name="discount" type="number" value="0" step="0.01" min="0" placeholder="0,00" class="form-control" />
			<label>Bonus</label> <input name="bonus" type="text" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Active</label><input name="active" type="number" value="0" step="1" min="0" max="1" class="form-control"/>
			<label>Administrator</label><input name="isAdmin" type="number" value="0" step="1" min="0" max="1" class="form-control" /> <BR />
		</fieldset>
		
		<input name="addCustomer" type="submit" class="btn btn-success" value="Add" />
		<input name="cancelCustomer" type="submit" class="btn btn-success" value="Cancel"/>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>