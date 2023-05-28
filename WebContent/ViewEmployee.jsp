<!DOCTYPE html>
<%@page import="com.java.dbhelper.EmployeeDbhelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.bean.EmployeeBean"%>
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
<%
	try
	{
		EmployeeBean b=new EmployeeBean();
		EmployeeDbhelper dbhelper=new EmployeeDbhelper();
		ArrayList<EmployeeBean> al=dbhelper.viewemployee();
%>
    <%@ include file="Navigation.jsp"%>
    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-caption">
                        <h2 class="page-title"></h2>
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
    <style>
table.blueTable {
  border: 1px solid #1C6EA4;
  background-color: #EEEEEE;
  width: 60%;
  text-align: left;
  border-collapse: collapse;
  }
table.blueTable td, table.blueTable th {
  border: 1px solid #AAAAAA;
  padding: 10px 10px;
}
table.blueTable tbody td {
  font-size: 13px;
}
table.blueTable tr:nth-child(even) {
  background: #D0E4F5;
}
table.blueTable thead {
  background: #1C6EA4;
  background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  border-bottom: 2px solid #444444;
}
table.blueTable thead th {
  font-size: 15px;
  font-weight: bold;
  color: #000000;
  border-left: 2px solid #D0E4F5;
}
table.blueTable thead th:first-child {
  border-left: none;
} 

table.blueTable tfoot {
  font-size: 14px;
  font-weight: bold;
  color: #FFFFFF;
  background: #D0E4F5;
  background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  background: -webkit-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  border-top: 2px solid #444444;
}
table.blueTable tfoot td {
  font-size: 14px;
}
table.blueTable tfoot .links {
  text-align: right;
}
table.blueTable tfoot .links a{
  display: inline-block;
  background: #1C6EA4;
  color: #FFFFFF;
  padding: 2px 8px;
  border-radius: 5px;
}
</style>
    
    <div class="content">
        <div class="container">
            <div class="row">
                
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                          
          <table align="center" cellspacing="10" border="1" cellpadding="6" class="blueTable">
										<thead>
											<tr>
												<td><b>Id</b></td>
												<td><b>First Name</b></td>
												<td><b>Last Name</b></td>
												<td><b>Address</b></td>
												<td><b>Mobile No</b></td>
												<td><b>EmailID</b></td>
												<td><b>Profile</b></td>
												
											</tr>
										</thead>
										<%
													for (int i = 0; i < al.size(); i++) {
											
														int id=al.get(i).getEmp_id();
														String Fname=al.get(i).getEmp_fname();
														String Lname=al.get(i).getEmp_lname();
														String Add=al.get(i).getEmp_address();
														String Mobileno=al.get(i).getEmp_mobileno();
														String Emailid=al.get(i).getEmp_email();
											
										%>
										<tr>
											<td><%=id%></td>										
											<td><%=Fname%></td>
											<td><%=Lname%></td>
											<td><%=Add%></td>
											<td><%=Mobileno%></td>
											<td><%=Emailid%></td>
											<td><a href="AddEmployeeProfile.jsp?EmpID=<%=id%>">Profile</a></td>
											
										</tr>
										<%
										}
										} catch (Exception ex) {
											out.println("Unable to connect to database.");
										}%>
									</table>

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
</body>

</html>
