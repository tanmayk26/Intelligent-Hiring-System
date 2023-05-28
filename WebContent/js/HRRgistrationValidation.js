function validateRegistration(form) {

//	alert("Welcome User Registration Validation");

	if (form.hr_fname.value == "") {
		alert("Error: firstname cannot be blank!");
		form.hr_fname.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.hr_fname.value)) {
		alert("Error: firstname should not contain numbers!");
		form.hr_fname.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.hr_fname.value)) {
		alert("Error: firstname should not contain other character!");
		form.hr_fname.focus();
		return false;
	}

	if (form.hr_lname.value == "") {
		alert("Error: lastname cannot be blank!");
		form.hr_lname.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.hr_lname.value)) {
		alert("Error: lastname should not contain numbers!");
		form.hr_lname.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.hr_lname.value)) {
		alert("Error: lastname should not contain other character!");
		form.hr_lname.focus();
		return false;
	}
	if (form.hr_address.value == "") {
		alert("Error: Address cannot be blank!");
		form.hr_address.focus();
		return false;
	}
	if (form.hr_mobileno.value == "") {
		alert("Error: Contact Number cannot be blank!");
		form.hr_mobileno.focus();
		return false;
	}
	re = /[0-9]/;
	if (!re.test(form.hr_mobileno.value)) {
		alert("Error: Contact Number contain digit!");
		form.hr_mobileno.focus();
		return false;
	}

	re = /^[0-9]{10,12}$/;
	if (!re.test(form.hr_mobileno.value)) {
		alert("Error: Enter 10 or 12 digit Contact Number!");
		form.hr_mobileno.focus();
		return false;
	}

	if (form.hr_email.value == "") {
		alert("Error: Email Id cannot be blank!");
		form.hr_email.focus();
		return false;
	}
	re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if (!re.test(form.hr_email.value)) {
		alert("Error: Invalid Email Id!");
		form.hr_email.focus();
		return false;
	}

	
	if (form.hr_username.value == "") {
		alert("Error: Username cannot be blank!");
		form.hr_username.focus();
		return false;
	}
	if (form.hr_password.value == "") {
		alert("Error: Password cannot be blank!");
		form.hr_password.focus();
		return false;
	}
	
	re = /[0-9]/;
	if (re.test(form.hr_username.value)) {
		alert("Error: Username should not contain numbers!");
		form.hr_username.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.hr_username.value)) {
		alert("Error: Username should not contain other character!");
		form.hr_username.focus();
		return false;
	}

	if (form.hr_password.value != "") {

		if (form.hr_password.value.length < 6) {
			alert("Error: Password must contain at least six characters!");
			form.hr_password.focus();
			return false;
		}
		if (form.hr_password.value == form.hr_username.value) {
			alert("Error: Password must be different from Username!");
			form.hr_password.focus();
			return false;
		}
		re = /[0-9]/;
		if (!re.test(form.hr_password.value)) {
			alert("Error: password must contain at least one number (0-9)!");
			form.hr_password.focus();
			return false;
		}
		re = /[a-z]/;
		if (!re.test(form.hr_password.value)) {
			alert("Error: password must contain at least one lowercase letter (a-z)!");
			form.hr_password.focus();
			return false;
		}
		re = /[A-Z]/;
		if (!re.test(form.hr_password.value)) {
			alert("Error: password must contain at least one uppercase letter (A-Z)!");
			form.hr_password.focus();
			return false;
		}
	} else {
		alert("Error: Please check that you've entered and confirmed your password!");
		form.hr_password.focus();
		return false;
	}

	return true;
}
