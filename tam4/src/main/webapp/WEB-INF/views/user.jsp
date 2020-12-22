<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>User page</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Left Panel -->
		<aside id="left-panel" class="left-panel">
			<jsp:include page="sideMenu.jsp" />
		</aside>
		<!-- End of Left Panel -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Header -->
				<header id="header" class="header">
					<jsp:include page="header.jsp" />
				</header>
				<!-- End of Header -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<div class="card">
						<div class="card-header">Employees</div>
						<div class="card-body">

							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#addUserModal">Add</button>

							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Email</th>
										<th>PhoneNumber</th>
										<th>Benefit</th>
										<th>Roles</th>
										<th>Team</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${users}" var="user">
										<tr>
											<td>${user.userId}</td>
											<td>${user.name}</td>
											<td>${user.email}</td>
											<td>${user.phoneNumber}</td>
											<td>${user.benefit}</td>
											<td>${user.roles}</td>
											<td>${user.team}</td>
											
											<td><a href="#" data-transfer="${user}"
												data-toggle="modal" data-target="#updateUserModal"
												class="btn btn-warning btn-circle"> <i
													class="fas fa-pencil-alt"></i>
											</a> <a
												href="/user/deleteUser?id=${user.userId}"
												class="btn btn-danger btn-circle"> <i
													class="fas fa-trash"></i>
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>

				</div>
				<!-- End Page Content -->
			</div>
		</div>
	</div>

	<!-- Modal place -->
	<form action="/user/createUser" method="POST">
		<div class="modal fade" tabindex="-1" id="addUserModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Add new user</h5>
						<button type="button" class="btn-close" data-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<div class="mb-3">
							<label class="form-label">Name</label> <input type="text"
								name="name" class="form-control" id="nameInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Email</label> <input type="email"
								name="email" class="form-control" id="emailInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Phone Number</label> <input type="tel"
								name="phoneNumber" class="form-control" id="phoneInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Benefit</label> <input type="tel"
								name="benefit" class="form-control" id="benefitInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Roles</label> <select multiple
								name="roles" class="form-control" id="rolesSelect">
								<option>Manager</option>
								<option>HR Manager</option>
								<option>Team Manager</option>
								<option>Intern</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Team</label> <select
								class="form-control" name="team" id="teamSelect">
								<option>Red Team</option>
								<option>Blue Team</option>
								<option>Green Team</option>
								<option>Yellow Team</option>
								<option>Orange Team</option>
							</select>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Add
							Employee</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<!-- Modal place -->
	<form action="/user/updateUser" method="POST">
		<div class="modal fade" tabindex="-1" id="updateUserModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Update employee</h5>
						<button type="button" class="btn-close" data-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<div class="mb-3">
							<label class="form-label">Name</label> <input type="text"
								name="name" class="form-control" id="nameInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Email</label> <input type="email"
								name="email" class="form-control" id="emailInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Phone Number</label> <input type="tel"
								name="phoneNumber" class="form-control" id="phoneInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Benefit</label> <input type="tel"
								name="benefit" class="form-control" id="benefitInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Roles</label> <select multiple
								name="roles" class="form-control" id="rolesSelect">
								<option>Manager</option>
								<option>HR Manager</option>
								<option>Team Manager</option>
								<option>Intern</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Team</label> <select
								class="form-control" name="team" id="teamSelect">
								<option>Red Team</option>
								<option>Blue Team</option>
								<option>Green Team</option>
								<option>Yellow Team</option>
								<option>Orange Team</option>
							</select>
						</div>
						<input type="hidden" id="userIdInput" name="userId"
							value=" ">

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Update
							Employee</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="/resources/js/sb-admin-2.min.js"></script>
	<script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	<script src="/resources/js/demo/datatables-demo.js"></script>

</body>

</html>