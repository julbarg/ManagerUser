/**
 * 
 */
function handleLoginRequest(xhr, status, args) {
	if (args.loggedIn) {
		try {
			$("#div_login").hide("drop", {
				direction : "up"
			}, 1000);
			setTimeout(function() {
				$("#div_manager").show("drop", {
					direction : "down"
				}, 1000);
			}, 1000);
			;
		} catch (err) {
		}
	}
}

function handleCloseRequest() {
	try {
		$("#div_manager").hide("drop", {
			direction : "down"
		}, 1000);
		setTimeout(function() {
			$("#div_login").show("drop", {
				direction : "up"
			}, 1000);
		}, 1000);

	} catch (err) {
	}

}

function timer() {
}

function readOnly(element) {
	element.readOnly = true;
}

function notReadOnly(element) {
	element.readOnly = false;
}