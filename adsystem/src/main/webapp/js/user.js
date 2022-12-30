//Các xử lý kịch bản cho user.html

function generatePermis(){
	//Khai báo danh sách quyền
	var permis = new Array();
	
	permis[0] = "---";
	permis[1] = "Members";
	permis[2] = "Authors";
	permis[3] = "Managers";
	permis[4] = "Administrator";
	permis[5] = "Super Admin";
	
	var opt = '<select class="form-select" id="permis" name="slcUserPermis"  >';
	for(let i=0; i<permis.length; i++){
		opt += '<option value="'+i+'">';
		opt += permis[i];
		opt += '</option>';
	}
	opt += '</select>';
	
	//In cấu trúc này ra màn hình
	document.write(opt);
}

function generateRoles(){
	//Khai báo danh sách vai trò thực thi
	let roles = new Array();
	roles[0] = "User";
	roles[1] = "Customer";
	roles[2] = "Order";
	roles[3] = "Product System";
	roles[4] = "Product Group";
	roles[5] = "Product Category";
	roles[6] = "Product";
	roles[7] = "Article Section";
	roles[8] = "Article Category";
	roles[9] = "Article";
	roles[10] = "Log";
	
	var role = '';
	for(let i=0; i<roles.length; i++){
		if(i%3 == 0){
			//Mở dòng
			role += '<div class="row align-items-center my-2">';
		}
		
		role += '<div class="col-md-4 ">';
		role += '<i class="fa-solid fa-user-tie"></i> &nbsp;';
		role += '<input class="form-check-input" type="checkbox" id="chk'+i+'" disabled  name="chks" onClick="checkPermis()" > &nbsp;';
		role += '<label class="form-check-label" for="chk'+i+'">'+roles[i]+' management</label>';
		role += '</div>';
		
		
		if((i%3 == 2) || (i==roles.length-1)){
			//Đóng dòng
			role += '</div>';
		}
	}
	
	//Xuất cấu trúc
	document.write(role);
	
}

function setCheckBox(check, dis){
	//Tham chiếu đối tượng form để làm việc
	let fn = document.getElementById('frmUser');
	
	//Duyệt các phần tử của form
	for(var i=0; i<fn.elements.length; i++){
		if(fn.elements[i].type == "checkbox" && fn.elements[i].name == "chks"){
			fn.elements[i].checked = check;
			fn.elements[i].disabled = dis;
		}
	}
	
}

function refreshPermis(){
	//Lấy quyền thực thi
	var permis = parseInt(document.getElementById('permis').value);
	
	//admin
	if(permis == 4 || permis == 5){
		this.setCheckBox(true, true);
	}else if(permis == 3){
		this.setCheckBox(true, false);
	}else if(permis == 2){
		this.setCheckBox(false, false);
	}else{
		this.setCheckBox(false, true);
	}
	
	//Gọi sự kiện kiểm tra vai trò
	this.checkPermis();
	
}

function checkName(){
	//Lấy thông tin trên giao diện
	let name = document.getElementById('name').value;
	
	//Tham chiếu đối tượng báo lỗi
	let errName = document.getElementById('errName');
	
	//Tham chiếu đối tượng hộp thư
	let email = document.getElementById('email');
	document.getElementById('errEmail').style.display = "block";
	
	//Khai báo biến xác nhận hợp lệ
	var validUserName = true;
	
	//Khai báo biến ghi nhận thông báo
	var message = "";
	
	//Kiểm tra tên và xử lý
	name = name.trim();
	if(name==""){
		validUserName = false;
		message = "Thiếu tên đăng nhập cho tài khoản.";
	}else{
		if((name.length<5) || (name.length>50)){
			validUserName = false;
			message = "Tên đăng nhập cho tài khoản, quá dài hoặc quá ngắn.";
		}else{
			if(name.indexOf(" ")!=-1){
				validUserName = false;
				message = "Tên đăng nhập không được có dấu cách.";
			}else{
				if(name.indexOf("@")!=-1){
					var parttern = /\w+@\w+[.]\w/;
					if(!name.match(parttern)){
						validUserName = false;
						message = "Không đúng cấu trúc hộp thư";
						email.disabled = false;
					}else{
						email.disabled = true;
						email.value = "";
						document.getElementById('errEmail').style.display = "none";
					}
				}else{
					email.disabled = false;
				}
			}
		}
	}
	
	//Xuất thông báo
	if(!validUserName){
		errName.innerHTML = message;
		errName.style.backgroundColor = "red";
		errName.style.color = "yellow";
	}else{
		errName.innerHTML = '<i class="fa-solid fa-square-check"></i>';
		errName.style.backgroundColor = "transparent";
		errName.style.color = "blue";
	}
	
	return validUserName;
	
}

function checkPass(){
	//lấy dữ liệu
	let pass = document.getElementById('pass').value;
	let pass2 = document.getElementById('pass2').value;
	
	//Biến xác nhận hợp lệ
	var validUserPass = true;
	
	//Biến ghi nhận thông báo
	var message = "";
	
	//Biến tham chiếu vị trí báo lỗi
	let errPass = document.getElementById('errPass');
	
	//Kiểm tra
	pass = pass.trim();
	if(pass==""){
		validUserPass = false;
		message = "Thiếu mật khẩu cho tài khoản mới.";
	}else{
		if(pass.length<6){
			validUserPass = false;
			message = "Mật khẩu quá ngắn, cần lớn hơn hoặc bằng 6 ký tự trở lên.";
			document.getElementById('pass2').disabled = false;
		}else{
			let name = document.getElementById('name').value;
			name = name.trim();
			if((name!="") && (pass.indexOf(name)!=-1)){
				validUserPass = false;
				message = "Mật khẩu không nên chứa tên đăng nhập.";
				document.getElementById('pass2').disabled = true;
				
			}else{
				document.getElementById('pass2').disabled = false;
				if(pass2!=""){
					if(pass!=pass2){
						validUserPass = false;
						message = "Mật khẩu xác nhận lại chưa đúng.";
					}
				}else{
					validUserPass = false;
					message = "Hãy nhập lại mật khẩu để đảm bảo chính xác.";
				}
			}
			
		}
		
	}
	
	//Xuất thông báo
	if(!validUserPass){
		errPass.innerHTML = message;
		errPass.style.backgroundColor = "red";
		errPass.style.color = "yellow";
	}else{
		errPass.innerHTML = '<i class="fa-solid fa-check-double"></i>';
		errPass.style.backgroundColor = "transparent";
		errPass.style.color = "blue";
	}
	
	return validUserPass;
}

function checkEmail(){
	//Lấy giá trị
	let email = document.getElementById('email').value;
	
	//Biến xác nhận hợp lệ
	var validUserEmail = true;
	
	//Biến ghi nhận thông báo
	var message = "";

	//Tham chiếu vị trí báo lỗi
	let errEmail = document.getElementById('errEmail');
	
	//Kiểm tra
	email = email.trim();
	
	if(email==""){
		validUserEmail = false;
		message = "Thiếu hộp thư cho tài khoản.";
	}else{
		if(email.indexOf("@")!=-1){
			var parttern = /\w+@\w+[.]\w/;
			if(!email.match(parttern)){
				validUserEmail = false;
				message = "Không đúng cấu trúc hộp thư.";
			}
			
		}else{
			validUserEmail = false;
			message = "Hãy nhập vào cấu trúc hộp thư chuẩn.";
		}
	}
	
	//Xuất thông báo
	if(!validUserEmail){
		errEmail.innerHTML = message;
		errEmail.style.backgroundColor = "red";
		errEmail.style.color = "yellow";
	}else{
		errEmail.innerHTML = '<i class="fa-solid fa-check-double"></i>';
		errEmail.style.backgroundColor = "transparent";
		errEmail.style.color = "blue";
	}
	
	return validUserEmail;

}

function checkPermis(){
	//Lấy giá trị
	let permis = parseInt(document.getElementById('permis').value);
	
	//Biến xác nhận hợp lệ
	var validUserPermis = true;
	
	//Biến ghi nhận lỗi
	var message = "Cần phải có ít nhất 1 vai trò cho Quyền thực thi này.";
	
	//Tham chiếu vị trí lỗi
	let errPermis = document.getElementById('errPermis');
	
	//Kiểm tra trong trường hợp Author và Manager
	if((permis == 2) || (permis==3)){
		//Tham chiếu form
		let fn = document.getElementById('frmUser');
		//Duyệt và kiểm tra lựa chọn
		for(var i=0; i<fn.elements.length; i++){
			if((fn.elements[i].type == "checkbox") && (fn.elements[i].name == "chks")){
				if(fn.elements[i].checked){
					validUserPermis = true;
					break;
				}else{
					validUserPermis = false;
				}
			}
		}
		
	}
	

	
	//Xuất thông báo
	if(!validUserPermis){
		errPermis.innerHTML = message;
		errPermis.style.display = 'block';
		errPermis.style.backgroundColor = "red";
		errPermis.style.color = "yellow";
	}else{
		if(permis==0 || permis==1){
			errPermis.style.display = 'none';
		}else{
			errPermis.innerHTML = '<i class="fa-solid fa-check-double"></i>';
			errPermis.style.display = 'block';
			errPermis.style.backgroundColor = "transparent";
			errPermis.style.color = "blue";
		}
	}
	
	return validUserPermis;
	
}

function checkValidUser(){
	let checkName = this.checkName();
	
	let checkPass = this.checkPass();
	
	let checkEmail = this.checkEmail();
	
	//let checkPermis = this.checkPermis();
	
	//Di chuyển con trỏ trên giao diện theo thứ tự từ trên xuống, từ trái sang
	if(!checkName){
		document.getElementById('name').focus();
	}else if(!checkPass){
		document.getElementById('pass').focus();
		document.getElementById('pass').select();
	}else if(!checkEmail){
		document.getElementById('email').focus();
		document.getElementById('email').select();
	}else if(!checkPermis){
		document.getElementById('permis').focus();
	}
	
	return checkName && checkPass && checkEmail ;
}

function createAccount(fn){
	
	if(this.checkValidUser()){
		fn.method = "POST";
		fn.action = "/adv/user/add";
		fn.submit();
	}
	
}


function editProfile(fn){
	fn.method = "post";
	fn.action = "/adv/user/profiles/edit";
	fn.submit();
}


