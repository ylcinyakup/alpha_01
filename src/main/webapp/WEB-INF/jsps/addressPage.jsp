<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class=" col-md-10 col-md-offset-1">
	<div class="table-responsive">
		<table class="table table-hover table-bordered">

			<tr>
				<th class="text-center col-md-1 info">Id</th>
				<th class="text-center col-md-2 info">Country</th>
				<th class="text-center col-md-1 info">City</th>
				<th class="text-center col-md-1 info">Neighborhood</th>
				<th class="text-center col-md-2 info">Street</th>
				<th class="text-center col-md-1 info">Building</th>
				<th class="text-center col-md-1 info">Door</th>
				<th class="text-center col-md-1 info" />
				<th class="text-center col-md-1 info" />
			</tr>

			<c:forEach var="addresses" items="${addresses}">
				<sf:form method="post" commandName="address"
					action="${pageContext.request.contextPath}/addressPage">
					<div>
						<tr class="text-center">
							<c:set var="id" value="${addresses.id}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" readonly="true" path="id" name="id"
									value="${id}"></sf:input></td>
							<c:set var="country" value="${addresses.country}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="country" name="country"
									value="${country}"></sf:input></td>
							<c:set var="city" value="${addresses.city}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="city" name="city" value="${city}"></sf:input></td>
							<c:set var="neighborhood" value="${addresses.neighborhood}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="neighborhood" name="neighborhood"
									value="${neighborhood}"></sf:input></td>
							<c:set var="street" value="${addresses.street}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="street" name="street"
									value="${street}"></sf:input></td>
							<c:set var="building" value="${addresses.building}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="building" name="building"
									value="${building}"></sf:input></td>
							<c:set var="door" value="${addresses.door}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="door" name="door" value="${door}"></sf:input></td>



							<td class="active"><input class="btn btn-info" name="update"
								type="submit" value="update" /></td>
							<td class="active"><input class="btn btn-danger "
								name="delete" type="submit" value="delete" /></td>
						</tr>



					</div>
				</sf:form>
			</c:forEach>

			<sf:form method="post" commandName="address"
				action="${pageContext.request.contextPath}/addressPage">
				<div>
					<tr class="text-center">
						<td class="active"></td>
						<td class="active"><sf:input type="text" class="form-control"
								path="country" name="country"></sf:input></td>
						<td class="active"><sf:input type="text" class="form-control"
								path="city" name="city"></sf:input></td>
						<td class="active"><sf:input type="text" class="form-control"
								path="neighborhood" name="neighborhood"></sf:input></td>
						<td class="active"><sf:input type="text" class="form-control"
								path="street" name="street"></sf:input></td>
						<td class="active"><sf:input type="text" class="form-control"
								path="building" name="building"></sf:input></td>
						<td class="active"><sf:input type="text" class="form-control"
								path="door" name="door"></sf:input></td>


						<td class="active"><input class="btn btn-success"
							name="create" type="submit" value="create" /></td>

					</tr>



				</div>
			</sf:form>
		</table>
	</div>
</div>