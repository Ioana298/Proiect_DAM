<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Schedule Page</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Calendar style -->
<link href="/resources/calendar/css/main.css" rel="stylesheet"
	type="text/css">
<link href="/resources/calendar/icons/style.css" rel="stylesheet"
	type="text/css">

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
						<div class="card-header">

							<div class="row p-0 m-0">
								<div class="col-sm-8 p-0 pl-3 m-0">Schedules</div>
								<div class="col-sm-4 p-0 pr-3 m-0">

									<div class="row p-0 m-0 p-0">

										<div class="col-sm-5 align-middle text-center p-0">
											<label class="checkbox-inline align-middle"><input
												type="checkbox" id="weekends" checked> Show weekend</label>
										</div>

										<div
											class="col-sm-4 row flex-nowrap form-group text-center align-middle p-0 m-0">
											<label for="exportType"
												class="col-sm-6 control-label align-middle p-0 m-0 mb-0">
												Export:</label>
											<div class="col-sm-6 p-0">
												<select class="form-control form-control-sm p-0" id="format"
													name="exportType">
													<option value="svg">SVG</option>
													<option value="jpeg">JPEG</option>
													<option value="png">PNG</option>
												</select>
											</div>
										</div>

										<div class="col-sm-3 align-middle p-0 pl-1">
											<button class="btn btn-outline-primary btn-sm" id="download">Download</button>


										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="card-body">

							<div class="main">
								<div class="wrap">
									<div class="left">
										<div id="nav"></div>
									</div>
									<div class="right">
										<div id="dp"></div>
									</div>
								</div>
							</div>


						</div>
					</div>

				</div>
				<!-- End Page Content -->
			</div>
		</div>
	</div>

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- DayPilot library -->
	<script src="/resources/calendar/js/daypilot/daypilot-all.min.js"></script>

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="/resources/js/sb-admin-2.min.js"></script>

	<script>
		var nav = new DayPilot.Navigator("nav");
		nav.showMonths = 2;
		nav.skipMonths = 1;
		nav.selectMode = "month";
		nav.onTimeRangeSelected = function(args) {
			dp.startDate = args.day;
			dp.update();
			dp.events.load("/api/events");
		};
		nav.init();

		var dp = new DayPilot.Month("dp");
		dp.eventEndSpec = "Date";
		dp.onTimeRangeSelected = function(args) {
			DayPilot.Modal.prompt("Create a new task:", "Task").then(
					function(modal) {
						dp.clearSelection();
						if (!modal.result) {
							return;
						}
						var params = {
							start : args.start.toString(),
							end : args.end.toString(),
							text : modal.result,
							resource : args.resource
						};
						DayPilot.Http.ajax({
							url : '/api/events/create',
							data : params,
							success : function(ajax) {
								var data = ajax.data;
								dp.events.add(data);
								dp.message("Task created");
							},

						})
					});
		};
		dp.onEventMove = function(args) {
			var params = {
				id : args.e.id(),
				start : args.newStart.toString(),
				end : args.newEnd.toString(),
				resource : args.newResource
			};
			DayPilot.Http.ajax({
				url : '/api/events/move',
				data : params,
				success : function(ajax) {
					dp.message("Moved");
				},
			})
		};
		dp.onEventResize = function(args) {
			var params = {
				id : args.e.id(),
				start : args.newStart.toString(),
				end : args.newEnd.toString(),
				resource : args.e.resource()
			};
			DayPilot.Http.ajax({
				url : '/api/events/move',
				data : params,
				success : function(ajax) {
					dp.message("Resized");
				},
			});
		};
		dp.onBeforeEventRender = function(args) {
			args.data.backColor = args.data.color;
			args.data.areas = [ {
				top : 4,
				right : 4,
				width : 12,
				height : 14,
				icon : "icon-triangle-down",
				visibility : "Visible",
				action : "ContextMenu",
				style : "font-size: 12px; background-color: #fff; border: 1px solid #ccc; padding: 2px 2px 0px 2px; cursor:pointer;"
			} ];
		};
		dp.contextMenu = new DayPilot.Menu({
			items : [ {
				text : "Delete",
				onClick : function(args) {
					var e = args.source;
					var params = {
						id : e.id()
					};
					DayPilot.Http.ajax({
						url : '/api/events/delete',
						data : params,
						success : function(ajax) {
							dp.events.remove(e);
							dp.message("Deleted");
						},
					});
				}
			}, {
				text : "-"
			}, {
				text : "Team 1",
				icon : "icon icon-blue",
				color : "#a2c4c9",
				onClick : function(args) {
					updateColor(args.source, args.item.color);
				}
			}, {
				text : "Team 2",
				icon : "icon icon-green",
				color : "#b6d7a8",
				onClick : function(args) {
					updateColor(args.source, args.item.color);
				}
			}, {
				text : "Team 3",
				icon : "icon icon-yellow",
				color : "#ffe599",
				onClick : function(args) {
					updateColor(args.source, args.item.color);
				}
			}, {
				text : "Team 4",
				icon : "icon icon-red",
				color : "#ea9999",
				onClick : function(args) {
					updateColor(args.source, args.item.color);
				}
			}, {
				text : "Default",
				color : "auto",
				onClick : function(args) {
					updateColor(args.source, args.item.color);
				}
			},

			]
		});
		dp.init();

		dp.events.load("/api/events");

		function updateColor(e, color) {
			var params = {
				id : e.id(),
				color : color
			};
			DayPilot.Http.ajax({
				url : '/api/events/setColor',
				data : params,
				success : function(ajax) {
					e.data.color = color;
					dp.events.update(e);
				},
			});
		}

		var elements = {
			weekends : document.querySelector("#weekends"),
			download : document.querySelector("#download"),
			format : document.querySelector("#format")
		};

		elements.weekends.addEventListener("click", function() {
			dp.showWeekend = elements.weekends.checked;
			dp.update();
		});

		elements.download.addEventListener("click", function() {
			var format = elements.format.value;
			dp.exportAs(format).download();
		});
	</script>
</body>

</html>