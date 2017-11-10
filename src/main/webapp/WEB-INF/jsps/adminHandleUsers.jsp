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
				<th class="text-center col-md-1 info">Username</th>
				<th class="text-center col-md-2 info">Password</th>
				<th class="text-center col-md-1 info">Name</th>
				<th class="text-center col-md-1 info">Surname</th>
				<th class="text-center col-md-2 info">Email</th>
				<th class="text-center col-md-1 info">Balance</th>
				<th class="text-center col-md-1 info">Authority</th>
				<th class="text-center col-md-1 info">Enabled</th>
				<th class="text-center col-md-1 info" />
				<th class="text-center col-md-1 info" />
			</tr>

			<c:forEach var="users" items="${users}">
				<sf:form method="post" commandName="user"
					action="${pageContext.request.contextPath}/adminHandleUsers">
					<div>
						<tr class="text-center">
							<c:set var="un" value="${users.username}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" readonly="true" path="username"
									name="username" value="${un}"></sf:input></td>
							<c:set var="pw" value="${users.password}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="password" name="password"
									value="${pw}"></sf:input></td>
							<c:set var="nm" value="${users.name}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="name" name="name" value="${nm}"></sf:input></td>
							<c:set var="snm" value="${users.surname}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="surname" name="surname"
									value="${snm}"></sf:input></td>
							<c:set var="eml" value="${users.email}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="email" name="email" value="${eml}"></sf:input></td>
							<c:set var="blnc" value="${users.balance}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="balance" name="balance"
									value="${blnc}"></sf:input></td>
							<c:set var="athrty" value="${users.authority}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="authority" name="authority"
									value="${athrty}"></sf:input></td>
							<c:set var="enbld" value="${users.enabled}"></c:set>
							<td class="active"><sf:input type="text"
									class="form-control" path="enabled" name="enabled"
									value="${enbld}"></sf:input></td>


							<td class="active"><input class="btn btn-info" name="update"
								type="submit" value="update" /></td>
							<td class="active"><input class="btn btn-danger "
								name="delete" type="submit" value="delete" /></td>
						</tr>



					</div>
				</sf:form>
			</c:forEach>
		</table>
	</div>
</div>