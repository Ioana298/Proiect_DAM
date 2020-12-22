<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Team Page</title>

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
						<div class="card-header">Teams</div>
						<div class="card-body">
							<h1>${text}</h1>
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Id</th>
										<th>Name</th>
										
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${teams}" var="team">
									<tr>
										<td>${team.teamId}</td>
										<td>${team.teamname}</td>
										<td><div class="text-center">
													<c:forEach items="${team.users}" var="u">
														<c:out value="${u.name}" />
													</c:forEach>
												</div>
												</td>
												<td><a href="#" data-transfer="${team}"
												data-toggle="modal" data-target="#updateTeamModal"
												class="btn btn-warning btn-circle"> <i
													class="fas fa-pencil-alt"></i>
											</a> <a
												href="/team/deleteTeam?id=${team.teamId}"
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
					
				</div>
				<!-- End Page Content -->
			</div>
		</div>
	</div>
<!-- Modal place -->
	<form action="/team/createTeam" method="POST">
		<div class="modal fade" tabindex="-1" id="addTeamModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Add new team</h5>
						<button type="button" class="btn-close" data-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<div class="mb-3">
							<label class="form-label">Name</label> <input type="text"
								name="name" class="form-control" id="nameInput">
						</div>
					
						<div class="mb-3">
							<label class="form-label">Users</label> <select
								class="form-control" id="usersSelect">
								<c:forEach var="u" items="${users}">
									<option value="${u.userId}">${u.name}</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Add
							Team</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<!-- Modal place -->
	<form action="/team/updateTeam" method="POST">
		<div class="modal fade" tabindex="-1" id="updateTeamModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Update team</h5>
						<button type="button" class="btn-close" data-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<div class="mb-3">
							<label class="form-label">Name</label> <input type="text"
								name="name" class="form-control" id="nameInput">
						</div>					
						<div class="mb-3">
							<label class="form-label">User</label> <select
								class="form-control" id="internshipSelect">
								<c:forEach var="p" items="${users}">
									<option value="${u.userId}">${u.name}</option>
								</c:forEach>
							</select>
						</div>
						<input type="hidden" id="teamIdInput" name="teamId"
							value=" ">

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Update
							Team</button>
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