$(document).ready(function(e) {
	$('#country').change(function() {

		$("#state").find('option').remove();
		$('<option>').val(' ').text('-please select-').appendTo("#state");
		
		$("#city").find('option').remove();
		$('<option>').val(' ').text('-please select-').appendTo("#city");
		
		
		var country = $("#country").val();
		$.ajax({
			type: "GET",
			url: 'getStates?cid=' + country,
			success: function(data) {
				$.each(data, function(key, value) {
					$('<option></options>').val(key).text(value).appendTo("#state");

				})
			}
		})
	});

	$('#state').change(function() {
		$("#city").find('option').remove();
		$('<option>').val(' ').text('-please select-').appendTo("#city");
		
		var state = $("#state").val();
		$.ajax({
			type: "GET",
			url: 'getCity?sid=' + state,
			success: function(data) {
				$.each(data, function(key, value) {
					$('<option></options>').val(key).text(value).appendTo("#city");

				})
			}
		})
	});
	

	
});