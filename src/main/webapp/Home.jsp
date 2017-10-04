<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: Tomato";
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

.active {
	background-color: none;
}

 #pid {
	 padding:50px;
} 
 #plus {
	 height: 50px;
     width: 100px;
	  position:absolute;
  top:50%;
  left:50%;
  margin-top:275px; 
  margin-left:500px;
} 
  #buttn {
     margin: 10px;
	 padding:10px;
	 height: 50px;
     width: 300px;
}  

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>

<%
response.setHeader("Cache-Control",
        "no-cache, no-store, must-revalidate"); // HTTP 1.1.
       response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
       if(session.getAttribute("name")==null){
    	   response.sendRedirect("Login.jsp");
       }
%>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span> BankApp</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a><span class="glyphicon glyphicon-user"></span><%=session.getAttribute("name")%></a></li>
			<li><a href="Logout"><span
					class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>
	</div>
	</nav>
	<div class="container" id="pid">
			<button type="button" class="btn btn-primary btn-lg"
				onclick="display('Bangalore')" id="buttn">Bangalore</button>
				
			<button type="button" class="btn btn-primary btn-lg"
				onclick="display('mumbai')" id="buttn">Mumbai</button>
				
			<button type="button" class="btn btn-primary btn-lg"
				onclick="display('delhi')" id="buttn">Delhi</button>
	    	<br>
		
		
			<button type="submit" class="btn btn-info btn-lg" data-toggle="modal"
				data-target="#myModal" id="plus">+</button>
      
			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog" 
				style="z-index: 1060">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" data-toggle="modal">&times;</button>
							<h4 class="modal-title">Account Details</h4>
							<div class="modal-body">
								<table id=viewTable>
									<div class="row">
										<div class="col-md-10">
											<form action="account" method="post">
												<div class="form-group">
													<label> Name: </label> <input required type="text"
														class="form-control" name="uname" id="nameid" />
												</div>

												<div class="form-group">
													<label> Account Number: </label> <input
														class="form-control" type="number" name="accountNo" required
														id="accountid" />

												</div>
												<div class="form-group">
													<label> Bank Name: </label> <input class="form-control"
														type="text" name="bankName" required id="bankid" />
												</div>

												<div class="form-group">
													<label>City:</label> <select class="form-control"
														name="city" id="cityid">
														<option>Bangalore</option>
														<option>Mumbai</option>
														<option>Delhi</option>
													</select>
												</div>

												<div class="form-group">
													<div class="col-md-4">
														<button type="button" onclick="add()" class="btn btn-primary">Save</button>
													</div>
													<div class="col-md-4">
														<button type="button" class="btn btn-danger"
															data-dismiss="modal">Cancel</button>

													</div>
												</div>
											</form>
										</div>
									</div>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		
		<div class="modal fade" id="myModal1" role="dialog"
			style="z-index: 1050">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" id="city-title">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body" id="details-table"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
	$(document).ready(function(){
	
	});
	
		var currentCity = "";
		var currentid=0;
		var edited=0;
		
		function display(city) {
			currentCity = city;
			$.ajax({
						url : "AccordingToCity",
						
						type : "POST",
						dataType : "JSON",
						data : {
							city : city
						},
						success : function(result) {
							
							var data = ""

							+ "<table class='table table-striped'>"
									+ "<thead >" + "<tr>" + "<th>Id</th>"
									+ "<th>Name</th>"
									+ "<th>Account number</th>"
									+ "<th>Bank name</th>" + "</tr>"
									+ "</thead>" + "<tbody>";
							for ( var i in result) {
								data += "<tr><td>"
										+ result[i].id
										+ "</td><td>"
										+ result[i].name
										+ "</td><td>"
										+ result[i].accountNo
										+ "</td><td>"
										+ result[i].bankName
										+ "</td>"
										+ "<td><button type='button' class='btn btn-info' data-target='#myModal' id='update' data-toggle='modal' onclick='edit("
										+ result[i].id
										+ ")'>Update</button>"
										+ "<td><button type='button' class='btn btn-danger' onclick='remove("
										+ result[i].id + ")'>Delete</button>"
										+ "</tr>";
									
							}
							data += "</tbody></table>";
							$('#city-title').html();
							$('#details-table').html(data);
							$('#myModal1').modal('show');
						}
						});
		}
		 function add() {
			console.log("before ajax");
			console.log(currentid);
			$.ajax({
				url : "UpdateDetails",
				type : "POST",
				data : {
					id : currentid,
					pname:$('#nameid').val(),
					accountNo:$('#accountid').val(),
				    bankName:$('#bankid').val(),
				    city:$('#cityid').val()
				},

				success : function() {
					
					$('#nameid').val(" "),
					$('#accountid').val(" "),
					$('#bankid').val(" "),
					$('#cityid').val(" "),
					$('#myModal').modal('hide');
					 if(edited==1){
							display(currentCity);
							edited=0;
						} 				
					 currentid=0;
				},
				error : function(result){
					console.log("after ajax");
					console.log(result);

				}
				
			});
			 
		} 
		
		function remove(id) {
			$.ajax({
				url : "DeleteDetails",
				type : "POST",
				data : {
					id : id
				},
				success : function() {
					display(currentCity);
				}
			});
		}
		
		function edit(id) {
			currentid=id;
			edited=1;
			console.log("edit"+currentid)
			$.ajax({
				url : "ShowForUpdate",
				type : "POST",
				data : {
					id : id
				},
				dataType : "JSON",
				success : function(detail) {
				//	display(currenCity);
					$('#nameid').val(detail.name),
					$('#accountid').val(detail.accountNo),
					$('#bankid').val(detail.bankName),
					$('#cityid').val(detail.city),
					$('#myModal').modal('show');
				}
			});
		}
	</script>
	

</body>
</html>