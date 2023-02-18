MAX_FILE_SIZE = 102400; // 100KB
	
	moduleURL = "[[@{/users}]]";
	
	function checkEmailUnique(form) {
		url = "[[@{/users/check_email}]]";
		userEmail = $("#email").val();
		userId = $("#id").val();
		csrfValue = $("input[name='_csrf']").val();
		
		params = {id: userId, email: userEmail, _csrf: csrfValue};
		
		$.post(url, params, function(response) {
			if (response == "OK") {
				form.submit();
			} else if (response == "Duplicated") {
				showWarningModal("There is another user having the email " + userEmail);
			} else {
				showErrorModal("Unknown response from server");
			}
		}).fail(function() {
			showErrorModal("Could not connect to the server");
		});
		
		return false;
	}