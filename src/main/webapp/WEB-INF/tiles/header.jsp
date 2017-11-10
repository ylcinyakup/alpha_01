<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<div>
	<nav class="navbar navbar-inverse navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#myNavbar"
					aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/"><span
					class="glyphicon glyphicon-home"></span> Home</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Options <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<sec:authorize access="isAuthenticated()">
								<li><a
									href="${pageContext.request.contextPath}/addressPage">Address
										Page</a></li>
							</sec:authorize>
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>



				<!-- LOGIN İŞLEMLERİ BURADA  -->


				<sec:authorize access="isAnonymous()">


					<ul class="nav navbar-nav navbar-right">
						<li><p class="navbar-text">Already have an account?</p></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
							<ul class="dropdown-menu"
								style="min-width: 250px; padding: 14px 14px 0; overflow: hidden; background-color: rgba(240, 220, 220, .5);">
								<li>
									<div class="row">
										<div class="col-md-12">

											<form class="form" name='f'
												action='${pageContext.request.contextPath}/login'
												method="POST" accept-charset="UTF-8">
												<div class="form-group">
													<label class="sr-only" for="username">username</label> <input
														type="text" class="form-control" name="username"
														id="username" placeholder="username" required>
												</div>
												<div class="form-group">
													<label class="sr-only" for="exampleInputPassword2">Password</label>
													<input type="password" name="password" class="form-control"
														id="password" placeholder="Password" required>
													<div style="font-size: 12px;" class="text-right">
														<a href="">Forget the password ?</a>
													</div>
												</div>
												<div class="form-group">
													<button type="submit" name="submit" value="login"
														class="btn btn-primary btn-block">Sign in</button>
												</div>
												<input name="${_csrf.parameterName}" type="hidden"
													value="${_csrf.token}" />
												<div class="checkbox">
													<label> <input type="checkbox" name="remember-me">Keep
														Me Logged In
													</label>
												</div>
											</form>
										</div>
										<div class="text-center"
											style="background-color: rgba(255, 255, 255, .8); border-top: 1px solid #ddd; clear: both; padding: 14px;">
											New here ? <a href="<c:url value="newUser"></c:url>"><b>Join
													Us</b></a>
										</div>
									</div>
								</li>
							</ul></li>
					</ul>
				</sec:authorize>



				<!-- LOG OUT BURADA  -->

				<sec:authorize access="isAuthenticated()">
					<ul class="nav navbar-btn navbar-right">



						<c:url var="logoutUrl" value="/logout" />
						<form action="${logoutUrl}" method="post">
							<input class="btn btn-default"
								style="border: none; background-color: rgba(250, 225, 225, .9);"
								type="submit" value="Logout" /> <input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
					</ul>
				</sec:authorize>



				<!-- ADMİN PAGE BURADA  -->

				<sec:authorize access="isAuthenticated()">

					<ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath}/addressPage">Address
								Page</a></li>
						<li><a
							href="${pageContext.request.contextPath}/adminHandleUsers"><span
								class="glyphicon glyphicon-user"></span> Show Users</a></li>

						<li><a href="${pageContext.request.contextPath}/adminPage">Admin
								Page</a></li>




					</ul>
				</sec:authorize>
			</div>
		</div>
	</nav>
</div>