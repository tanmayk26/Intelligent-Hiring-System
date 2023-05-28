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
                        <h2 class="page-title">Criteria</h2>
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
							<form action="CriteriaServlet" method="post" name=form  >
                                <div class="row">
                                   
                                    <div class="col-md-6">
                                        <label class="control-label" for="name">Total Year Of Experience</label>
                                        <input type="text" name="total_year_of_exp" id="total_year_of_exp" placeholder="Enter Total Year Of Experience" class="form-control">
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
							alert('Criteria Added Successfully');
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
