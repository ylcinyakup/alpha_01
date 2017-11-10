<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>



<div class="container">
	<!-- Example row of columns -->
	<div class="row" style="height: 100px;"></div>

	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<c:if test="${param.error != null }">
				<strong class="text-danger">Login failed username password
					didnt match</strong>
			</c:if>

			<sf:form name='f' action='${pageContext.request.contextPath}/login'
				method='POST'>
				<div class="form-group">
					<label for="username">User:</label> <input type="text"
						name="username" id="username" class="form-control"
						placeholder="username" />

				</div>

				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						name="password" class="form-control" id="password"
						placeholder="password" />

				</div>


				<button name="submit" type="submit" value="Login"
					class="btn btn-info">login</button>

				<input name="${_csrf.parameterName}" type="hidden"
					value="${_csrf.token}" />
			</sf:form>
		</div>
	</div>

</div>
