let index = {
	init: function() {
		$("#btn-save").on("click", () => { // function() {} 대신에 ()=>{} 쓰는 이유 this를 바인딩 하기 위해서!!
			this.save();
		})
	},
/*	let _this = this;
	init: function() {
		$("#btn-save").on("click", function() { 
			_this.save();
		})
	},*/

	save: function() {
		let userData = {
			"username" : $("#username").val(),
			"password" : $("#password").val(),  
			"email" : $("#email").val()
		};
/*
		$.ajax({
			method: "POST",
			url: "/user/join", 
			data: data,
			dataType: json
		}).done(function(msg) {
			console.log("Data Saved: " + msg);
		}).fail(function() {
			console.log("error");
		})
*/
		$.ajax(
			{ 
				url: '/blog/user/join',  
				data: JSON.stringify(userData), 
				dataType: 'json',               /*html, text, json, xml, script*/
				contentType: 'application/json',
				method: 'post',
				success: function(res) { 
					console.log("success");
					console.log(res);
				},
				error: function(xhr, status, error) {
					console.log(xhr.status);           // 에러코드(404, 500 등)
					console.log(xhr.responseText); // html 포맷의 에러 메시지
					console.log(status);                // 'error'
					console.log(error);                 // 'Not Found'
				}
			}
		);
	}
}

index.init();