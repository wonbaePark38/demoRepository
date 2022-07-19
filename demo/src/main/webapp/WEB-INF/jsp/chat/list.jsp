<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VMS리스트</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
<body>
<header></header>
<article>
	<div class="container">
	  <div class="row">
			<c:forEach var="item" items="${list}">
				<div class="col">
					<div class="card" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title">웹소켓테스트</h5>
					    <p class="card-text">${item.vmsDesc}</p>
					    <input id="userName" type="text" />
					    <input type="button" class="btn btn-primary" id="${item.vmsId}" value = 'Enter' onclick="enterRoom(this.id)"/>
					  </div>
					</div>
				 </div>
			</c:forEach>
	  </div>
	</div>
	
</article>
<footer>
</footer>	
</body>
<script>
	function enterRoom(vmsId){
		//var userName = document.getElementById('userName').value;
		var vmsIdNode = document.getElementById(vmsId);
		var userName = vmsIdNode.previousElementSibling.value;
		
		var url = '/chat/enter/' + vmsId + '/' + userName;
		var name = 'VMS 제어팝업';
		var option = "width = 800, height = 800, top = 100, left = 200, location = no";
		window.open(url, name, option);
		
	}
	
	/*const enterBt = document.getElementsByClassName("btn btn-primary"); 
	enterBt.addEventListener('click', () => {
		alert('클릭');
	});
	*/
	/*enterBt.addEventListener('click', ()=>{
		
		var httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = () => {
			if(httpRequest.readyState === XMLHttpRequest.DONE){
				if(httpRequest.status === 200){
					var response = httpRequest.responseText;
					alert(response);
				}
			}
		}*/
		
		/*httpRequest.open('GET', '/chat/ajaxtest');
		httpRequest.responseType = 'text';
		httpRequest.send();
	});
	*/

</script>
</html>