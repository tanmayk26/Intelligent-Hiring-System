<div class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <a href="index.jsp"><img src="images/logo1.png" alt="#"></a>
                </div>
                <div class="col-lg-8 col-md-4 col-sm-12 col-xs-12">
                    <div class="navigation">
                        <div id="navigation">
                            <ul>
                                <li class="active"><a href="index.jsp" title="Home">Home</a></li>
                                <li ><a href="#" title="Service List">About Us</a>
                                </li>
                                <%
		try {

			String user = (String) session.getAttribute("role");
			if (user != null && user.equals("ADMIN")) {
	%>
                                <li class="has-sub"><a href="#" title="Blog ">HR Details</a>
                                    <ul>
                                        <li><a href="AddHR.jsp" title="Blog">Add HR</a></li>
                                        <li><a href="ViewHR.jsp" title="Blog Single ">View HR Details</a></li>
                                    </ul>
                                </li>
                                <li><a href="#" title="Features"> View Employee Details</a>
                                    <ul>
                                        <li><a href="AddEmployee.jsp" title="Service List">Add Employee</a></li>
										<li><a href="ViewEmployeeToAdmin.jsp">Employee Details</a></li>
                                        
                                    </ul>
                                </li>
                                <li><a href="logout.jsp">Logout</a></li>
                                <% 
		}else if (user != null && user.equals("HR")) {
			%>
			
			<li class="dropdown"><a href="#" data-toggle="dropdown"class="dropdown-toggle">Employee Details</a>
			<ul class="dropdown-menu">
				<li><a href="ViewEmployee.jsp">Employee Details</a></li>
				<li><a href="ViewEmployeeProfile.jsp">Employee Profile Details</a></li>
				
			</ul></li>
				<li><a href="AddCriteria.jsp">Upload Resume</a></li>
<!-- 				<li><a href="uploadResume.jsp">Upload Resume</a></li> -->
				<li><a href="logout.jsp">Logout</a></li>

	<%}else {
			%>
			 <li><a href="login.jsp" title="Contact Us">Login</a> </li>
				
		<%}
		} catch (Exception e) {
			System.out.println(e);
		}
	%>
                               
                               
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>