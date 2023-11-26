<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	Edit Customer:
	<form method="POST" action="EditCustomerServlet">
		<input type="hidden" name="customerId" value="${customer.customerId}" />
		<fieldset class="form-group">
			<label>Login</label> <input name="firstName" type="text" class="form-control" value="${customer.firstName}" />
			<label>Password</label> <input name="password" type="password" class="form-control" value="${customer.password}" />
			<label>Name</label> <input name="lastName" type="text" class="form-control" value="${customer.lastName}" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Email</label> <input name="email" type="email" placeholder="example@example.com" class="form-control" value="${customer.email}" />
			<label>Address</label> <input name="address" type="text" class="form-control" value="${customer.address}" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Discount</label> <input name="discount" type="number" step="0.01" min="0" placeholder="0,0000000" class="form-control" value="${customer.discount}" />
			<label>Bonus</label> <input name="bonus" type="text" class="form-control" value="${customer.bonus}" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Active</label><input name="active" type="number" step="1" min="0" max="1" class="form-control" value="${customer.active}"/>
			<label>Administrator</label><input name="isAdmin" type="number" step="1" min="0" max="1" class="form-control" value="${customer.isAdmin}"/> <BR />
		</fieldset>

		<input name="saveCustomer" type="submit" class="btn btn-success" value="Save" />
		<input name="cancelCustomer" type="submit" class="btn btn-success" value="Cancel"/>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>