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
                        <h2 class="page-title">Registration Form</h2>
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
    <div class="content">
        <div class="container">
            <div class="row">
                
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<form action="AddEmployeeServlet" method="post" name=form onsubmit="return validateRegistration(form)" >
                                <div class="row">
                                   
                                    <div class="col-md-6">
                                        <label class="control-label" for="name">First Name</label>
                                        <input type="text" name="emp_fname" id="emp_fname" placeholder="Enter First Name" class="form-control">
                                    </div>
                                    </div>
                               		 <div class="row">
 									<div class="col-md-6">
                                        <label class="control-label" for="name">Last Name</label>
                                        <input type="text" name="emp_lname" id="emp_lname" placeholder="Enter Last Name " class="form-control">
                                    </div>
                                    </div>
                               		 <div class="row">
                                     <div class="col-md-6">
                                        <label class="control-label" for="name">Address </label>
                                        <input type="text" name="emp_address" id="emp_address" placeholder="Enter Address " class="form-control">
                                    </div>                            
                                    </div>
                               		 <div class="row">
                                     <div class="col-md-6">
                                        <label class="control-label" for="name">Mobile Number </label>
                                        <input type="text" name="emp_mobileno" id="emp_mobileno" placeholder="Enter Mobile Number" class="form-control">
                                    </div>
                                    </div>
                               		 <div class="row">
                                     <div class="col-md-6">
                                        <label class="control-label" for="name">EmailID</label>
                                        <input type="text" name="emp_email" id="emp_email" placeholder="Enter EmailID" class="form-control">
                                    </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-default">Register</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                   <% if(request.getAttribute("flag")=="success" || request.getAttribute("flag1")=="done")
                    {%>
   					 <script type="text/javascript">
							alert('Employee Added Successfully');
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
    
</body>

</html>
