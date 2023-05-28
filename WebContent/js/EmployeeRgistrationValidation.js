function validateRegistration(form) {

//	alert("Welcome User Registration Validation");

	if (form.emp_fname.value == "") {
		alert("Error: firstname cannot be blank!");
		form.emp_fname.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.emp_fname.value)) {
		alert("Error: firstname should not contain numbers!");
		form.emp_fname.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.emp_fname.value)) {
		alert("Error: firstname should not contain other character!");
		form.emp_fname.focus();
		return false;
	}

	if (form.emp_lname.value == "") {
		alert("Error: lastname cannot be blank!");
		form.emp_lname.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.emp_lname.value)) {
		alert("Error: lastname should not contain numbers!");
		form.emp_lname.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.emp_lname.value)) {
		alert("Error: lastname should not contain other character!");
		form.emp_lname.focus();
		return false;
	}
	if (form.emp_address.value == "") {
		alert("Error: Address cannot be blank!");
		form.emp_address.focus();
		return false;
	}
	if (form.emp_mobileno.value == "") {
		alert("Error: Contact Number cannot be blank!");
		form.emp_mobileno.focus();
		return false;
	}
	re = /[0-9]/;
	if (!re.test(form.emp_mobileno.value)) {
		alert("Error: Contact Number contain digit!");
		form.emp_mobileno.focus();
		return false;
	}

	re = /^[0-9]{10,12}$/;
	if (!re.test(form.emp_mobileno.value)) {
		alert("Error: Enter 10 or 12 digit Contact Number!");
		form.emp_mobileno.focus();
		return false;
	}


	if (form.emp_email.value == "") {
		alert("Error: Email Id cannot be blank!");
		form.emp_email.focus();
		return false;
	}
	re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if (!re.test(form.emp_email.value)) {
		alert("Error: Invalid Email Id!");
		form.emp_email.focus();
		return false;
	}

	return true;
}
