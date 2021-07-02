let index = {
	init: function() {
		$("#btn-save").on("click", () => { // function() {} 대신에 ()=>{} 쓰는 이유 this를 바인딩 하기 위해서!!
			this.save();
		})
		$("#btn-login").on("click", () => { // function() {} 대신에 ()=>{} 쓰는 이유 this를 바인딩 하기 위해서!!
			this.login();
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
			"username": $("#username").val(),
			"password": $("#password").val(),
			"email": $("#email").val()
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
				url: '/blog/api/user',
				data: JSON.stringify(userData), // http body 데이터
				contentType: 'application/json; charset=utf-8', // body 데이터가 어떤 타입인지(MIME)
				dataType: 'json',               // 응답된 데이터 타입, 기본적으로 모두 문자열인데 (생긴게 json이면) => javascript에서 오브젝트로 변환
				method: 'post',
				success: function(res) {
					alert("회원가입이 완료되었습니다.");
					location.href = "/blog";
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
	},
	login: function() {
		let userData = {
			"username": $("#username").val(),
			"password": $("#password").val()
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
				url: '/blog/api/user/login',
				data: JSON.stringify(userData), // http body 데이터
				contentType: 'application/json; charset=utf-8', // body 데이터가 어떤 타입인지(MIME)
				dataType: 'json',               // 응답된 데이터 타입, 기본적으로 모두 문자열인데 (생긴게 json이면) => javascript에서 오브젝트로 변환
				method: 'post',
				success: function(res) {
					alert("로그인이 완료되었습니다.");
					location.href = "/blog";
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