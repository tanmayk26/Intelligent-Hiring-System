<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Hair salon templates for mens hair cut service provider.">
    <meta name="keywords" content="hair salon website templates free download, html5 template, free responsive website templates, website layout,html5 website templates, template for website design, beauty HTML5 templates, cosmetics website templates free download">
    <title>Resume server</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i%7cMontserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Style -->
    <link href="css/style.css" rel="stylesheet">
    
</head> 

<body>
    <%@ include file="Navigation.jsp"%>
    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-caption">
                        <h2 class="page-title"> </h2>
                        <div class="page-breadcrumb">
                            <ol class="breadcrumb">
                                <li><a href="index.jsp">Home</a></li>
                 
               
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <% String EmpID=request.getParameter("EmpID");
	System.out.println("EmpID :"+EmpID);
    %>
    <div class="content">
        <div class="container">
            <div class="row">
                
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<form action="EmployeeProfileServlet" method="post" name=form  onsubmit="return validateRegistration(form)" >
                                <div class="row">
                                   
                                    <div class="col-md-6">
                                        <input type="hidden" name="emp_id" id="emp_id" placeholder="Enter emp ID" class="form-control" value="<%=EmpID%>">
                                    </div>
                                    </div>
                               		 <div class="row">
 									<div class="col-md-6">
                                        <label class="control-label" for="name">Rating</label>
                                        <input type="text" name="rating" id="rating" placeholder="Enter Rating  " class="form-control" >
                                    </div>
                                    </div>
                               		 <div class="row">
                                     <div class="col-md-6">
                                        <label class="control-label" for="name">Gender </label>
                                        <select name="gender" id="gender" placeholder="Enter Gender " class="form-control">
                                   				<option value="Female" >Female</option>
												<option value="Male" >Male</option>
										</select>
                                    </div>                            
                                    </div>
                               		 <div class="row">
                                     <div class="col-md-6">
                                        <label class="control-label" for="name">University</label>
                                        <select  name="university" id="university" placeholder="Enter University" class="form-control">
												<option value="pune" >SPPU Pune</option>
												<option value="kolhapur" >Kolhapur</option>
												<option value="jalgaon" >Jalgaon</option>
												<option value="mumbai" >Mumbai</option>
												<option value="aurangabad" >Aurangabad</option>
										</select>
                                    </div>
                                    </div>
                               		 <div class="row">
 									<div class="col-md-6">
                                        <label class="control-label" for="name">Qualification</label>
											 <select  name="qualification" id="qualification" placeholder="Enter Qualification" class="form-control">
                                  				<option value="0" >Select</option>
												<option value="BE" >BE</option>
												<option value="BSC" >BSC</option>
												<option value="BTech" >BTech</option>
												<option value="MSC" >MSC</option>
												<option value="ME" >ME</option>
												<option value="MTech" >MTech</option>
											</select>                                    
                                    </div>
                                    </div>
                               		 <div class="row">
 									<div class="col-md-6">
                                        <label class="control-label" for="name">Technology</label>
                                        <input type="text" name="technology" id="technology" placeholder="Enter Technology" class="form-control">
                                    </div>
                                    </div>
                                    
                                     <div class="row">
                                     <div class="col-md-6">
                                        <label class="control-label" for="name">total_experience</label>
                                        <input type="text" name="total_experience" id="total_experience" placeholder="Enter total_experience" class="form-control">
                                    </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-default">Add</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                   <% if(request.getAttribute("flag")=="success" || request.getAttribute("flag1")=="done")
                    {%>
   					 <script type="text/javascript">
							alert('Employee Profile Added Successfully');
                    </script>
                   <%}%>                   
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>
    <!-- /.footer-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/menumaker.js"></script>
    <script src="js/jquery.sticky.js"></script>
	<script src="js/sticky-header.js"></script>
    <script src="js/EmployeeRgistrationValidation.js"></script>
    <script src="js/ProfileValidation.js"></script>
    
</body>

</html>
