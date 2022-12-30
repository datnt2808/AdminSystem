//Các xử lý kịch bản cho login_v3.html

function checkValidLogin(){
	//Lấy thông tin trên giao diện
	let name = document.getElementById("name").value;
	let pass = document.getElementById("pass").value;
	
	//Khai báo các biến xác thực giá trị
	var validUserName = true;
	var validUserPass = true;
	
	//Biến ghi nhận thông báo
	var message = "";
	
	//Kiểm tra và xử lý thông tin của name
	name = name.trim();
	if(name==""){
		validUserName = false;
		message = "Thiếu tên đăng nhập vào hệ thống.";
	}else{
		if(name.length<5 || name.length>50){
			validUserName = false;
			message = "Tên đăng nhập cần trong phạm vi từ 5 đến 50 ký tự.";
		}else{
			if(name.indexOf(" ")!=-1){
				validUserName = false;
				message = "Tên đăng nhập không chứa dấu cách.";
			}else if(name.indexOf("@")!=-1){
				var parttern = /\w+@\w+[.]\w/;
				if(!name.match(parttern)){
					validUserName = false;
					message = "Không đúng cấu trúc hộp thư.";
				}
			}
		}
	}
	//Xuất thông báo
	let errName = document.getElementById("errName");
	if(!validUserName){
		errName.innerHTML = message;
		errName.style.color = "yellow";
		errName.style.backgroundColor = "red";
		errName.style.fontWeight = "bold";
	}else{
		errName.innerHTML = '<i class="fa-solid fa-circle-check"></i>';
		errName.style.color = "blue";
		errName.style.backgroundColor = "transparent";
	}

	//Kiểm tra và xử lý pass
	pass = pass.trim();
	if(pass==""){
		validUserPass = false;
		message = "Thiếu mật khẩu đăng nhập vào hệ thống";
	}else{
		if(pass.length<6){
			validUserPass = false;
			message = "Mật khẩu quá ngắn, cần lớn hơn 5 ký tự.";
		}
	}
	//Xuất thông báo
	let errPass = document.getElementById("errPass");
	if(!validUserPass){
		errPass.innerHTML = message;
		errPass.style.color = "yellow";
		errPass.style.backgroundColor = "red";
		errPass.style.fontWeight = "bold";
	}else{
		errPass.innerHTML = '<i class="fa-solid fa-circle-check"></i>';
		errPass.style.color = "blue";
		errPass.style.backgroundColor = "transparent";
	}
	
	return validUserName && validUserPass;
}

function login(fn){
	if(this.checkValidLogin()){
		fn.method = "post"; //Gọi vào phương thức doPost()
		fn.action = "/adv/user/login"; //Đường dẫn thực thi servlet
		fn.submit();
	}
}



