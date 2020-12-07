<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="/landingPage">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laptop-code"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			TAM <sup>4</sup>
		</div>
	</a>

	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item"><a class="nav-link" href="/landingPage"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a></li>

	<hr class="sidebar-divider">
	<div class="sidebar-heading">Candidate</div>

	<!-- Nav Item - Internships -->
	<li class="nav-item"><a class="nav-link" href="/internship/getAllInternships"> <i class="fas fa-tasks"></i> <span>Internships</span></a></li>
	<hr class="sidebar-divider">
	<div class="sidebar-heading">Recruitment</div>

	<!-- Nav Item - Candidates, Employee -->
	<li class="nav-item"><a class="nav-link" href="/candidate/getAllCandidates"> <i class="fas fa-user-graduate"></i> <span>Candidates</span></a></li>
	<li class="nav-item"><a class="nav-link" href="/user/getAllUsers"> <i class="fas fa-user-tie"></i> <span>Employees</span></a></li>

	<hr class="sidebar-divider">
	<div class="sidebar-heading">Management</div>

	<!-- Nav Item - Projects, Schedule, Teams-->
	<li class="nav-item"><a class="nav-link" href="/project/getAllProjects"> <i class="fas fa-chart-line"></i> <span>Projects</span></a></li>
	<li class="nav-item"><a class="nav-link" href="index.html"> <i class="far fa-calendar-alt"></i> <span>Schedule</span></a></li>
	<li class="nav-item"><a class="nav-link" href="index.html"> <i class="fas fa-users"></i> <span>Teams</span></a></li>

	<hr class="sidebar-divider d-none d-md-block">
	<div class="sidebar-heading">Admin</div>

	<!-- Nav Item - Projects -->
	<li class="nav-item"><a class="nav-link" href="index.html"> <i class="fas fa-cogs"></i> <span>Settings</span></a></li>

	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>
</ul>
<!-- End of Sidebar -->