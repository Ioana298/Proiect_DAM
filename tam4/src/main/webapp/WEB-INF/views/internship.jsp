<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Internship page</title>

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
						<div class="card-header">Internships</div>
						<div class="card-body">

							<!-- Button trigger modal -->
							<sec:authorize access="hasAnyRole('ROLE_HR','ROLE_MANAGER','ROLE_TEAMLIDER')">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#addInternshipModal">Add</button>
							</sec:authorize>

							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Project</th>
										<th>Start date</th>
										<th>End date</th>
										<th>Is paid</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${internships}" var="internship">
										<tr>
											<td>${internship.internshipId}</td>
											<td>${internship.name}</td>
											<td>${internship.project.name}</td>
											<td>${internship.startDate}</td>
											<td>${internship.endDate}</td>
											<td>${internship.isPaid}</td>
											<td><a href="#" data-transfer="${internship}"
												data-toggle="modal" data-target="#updateInternshipModal"
												class="btn btn-warning btn-circle"> <i
													class="fas fa-pencil-alt"></i>
											</a> <a
												href="/internship/deleteInternship?id=${internship.internshipId}"
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
	<form action="/internship/createInternship" method="POST">
		<div class="modal fade" tabindex="-1" id="addInternshipModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Add new internship</h5>
						<button type="button" class="btn-close" data-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<div class="mb-3">
							<label class="form-label">Name</label> <input type="text"
								name="name" class="form-control" id="nameInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Project</label> <select
								class="form-control" name="project" id="projectSelect">
								<c:forEach var="p" items="${projects}">
									<option value="${p.projectId}">${p.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Start date</label> <input type="date"
								name="startDate" class="form-control" id="startDateInput">
						</div>
						<div class="mb-3">
							<label class="form-label">End date</label> <input type="date"
								name="endDate" class="form-control" id="endDateInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Is Paid</label> <input type="checkbox"
								name="isPaid" class="form-control" id="isPaidInput">
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Add
							Internship</button>
					</div>
				</div>
			</div>
		</div>
	</form>


	<!-- Modal place -->
	<form action="/internship/updateInternship" method="POST">
		<div class="modal fade" tabindex="-1" id="updateInternshipModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Update internship</h5>
						<button type="button" class="btn-close" data-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<div class="mb-3">
							<label class="form-label">Name</label> <input type="text"
								name="name" class="form-control" id="nameInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Project</label> <select
								class="form-control" name="project" id="projectSelect">
								<c:forEach var="p" items="${projects}">
									<option value="${p.projectId}">${p.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Start date</label> <input type="date"
								name="startDate" class="form-control" id="startDateInput">
						</div>
						<div class="mb-3">
							<label class="form-label">End date</label> <input type="date"
								name="endDate" class="form-control" id="endDateInput">
						</div>
						<div class="mb-3">
							<label class="form-label">Is Paid</label> <input type="checkbox"
								name="isPaid" class="form-control" id="isPaidInput">
						</div>
						<input type="hidden" id="internshipIdInput" name="internshipId"
							value="3">

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Update
							Internship</button>
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

	<script>
	//not functional yet
	
	//triggered when modal is about to be shown
	$('#updateInternshipModal').on('show.bs.modal', function(e) {

	    //get data-id attribute of the clicked element
	    var internship = $(e.relatedTarget).data('transfer');

	    //populate the textbox
	    $(e.currentTarget).find('input[name="name"]').val(${internship.name});
	    $(e.currentTarget).find('input[name="project"]').val(${internship.project.name});
	    $(e.currentTarget).find('input[name="startDate"]').val(${internship.startDate});
	    $(e.currentTarget).find('input[name="endDate"]').val(${internship.endDate});
	    $(e.currentTarget).find('input[name="isPaid"]').val(${internship.isPaid});
	});
	</script>


</body>

</html>