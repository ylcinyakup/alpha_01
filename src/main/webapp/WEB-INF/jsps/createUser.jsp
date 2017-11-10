<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<div class="container" style="margin-top: 70px;">
	<!-- <div class="well bs-component col-md-4 col-md-offset-4"> -->
	<div class=" col-md-4 col-md-offset-4"
		style="border-radius: 5%; max-width: 90%; padding: 14px 14px 0; overflow: hidden; background-color: rgba(255, 255, 255, .8);">
		<!-- Example row of columns -->
		<div class="panel-heading">
			<div class="panel-title text-center">
				<h1 class="title">Create User</h1>
				<hr />
			</div>
		</div>

		<div class="row">
			<div class="align-middle" style="text-align: center;">
				<sf:form method="post"
					action="${pageContext.request.contextPath}/createUser"
					commandName="user">
					<div class="form-group"
						style="margin-left: 10%; margin-right: 10%;">
						<label style="display: block; text-align: center;" for="Username">Username:</label>
						<sf:input type="text" path="username" name="username"
							class="form-control" placeholder="Enter Your Username" />
						<p>
							<strong> <sf:errors path="username" class=" text-danger"></sf:errors></strong>
						</p>
					</div>

					<div class="form-group"
						style="margin-left: 10%; margin-right: 10%;">
						<label for="password">Password:</label>
						<sf:input id="password" type="password" path="password"
							name="password" class="form-control" placeholder="Password" />
						<p>
							<strong> <sf:errors path="password" class=" text-danger"></sf:errors></strong>
						</p>
					</div>
					<strong id="matchpass"></strong>
					<div class="form-group"
						style="margin-left: 10%; margin-right: 10%;">
						<label for="password">Password:</label> <input
							id="confirmpassword" type="password" name="confirmpassword"
							class="form-control" placeholder="Confirm Password" />

					</div>
					<div class="form-group"
						style="margin-left: 10%; margin-right: 10%;">
						<label style="display: block; text-align: center;" for="name">Name:</label>
						<sf:input type="text" path="name" name="name" class="form-control"
							placeholder="Enter Your Name" />
						<p>
							<strong> <sf:errors path="name" class=" text-danger"></sf:errors></strong>
						</p>
					</div>
					<div class="form-group"
						style="margin-left: 10%; margin-right: 10%;">
						<label style="display: block; text-align: center;" for="surname">Surname:</label>
						<sf:input type="text" path="surname" name="surname"
							class="form-control" placeholder="Enter Your Surname" />
						<p>
							<strong> <sf:errors path="surname" class=" text-danger"></sf:errors></strong>
						</p>
					</div>

					<div class="form-group"
						style="margin-left: 10%; margin-right: 10%;">
						<label for="email">Email:</label>
						<sf:input type="email" path="email" name="email"
							class="form-control" placeholder="Enter Your Email" />
						<p>
							<strong> <sf:errors path="email" class=" text-danger"></sf:errors></strong>
						</p>
					</div>



					<button style="margin-bottom: 10%;" type="submit"
						class="btn btn-info">Create it</button>
				</sf:form>
			</div>
		</div>


	</div>
</div>