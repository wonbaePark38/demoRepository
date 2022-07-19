<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VMS제어팝업</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
<body>
	<article>
		<div id="_chatbox" style="display: block">
        <fieldset>
            <div id="messageWindow"></div>
            <br /> <input id="inputMessage" type="text" />
            <button type="button" class="btn btn-success" id="send-bt">전송</button>
        </fieldset>
    </div>
	</article>
	<footer>
		
	</footer>
</body>
<script>
	var sockJs = new SockJS("/stomp/chat");
	var stomp = Stomp.over(sockJs);
	var vmsId = '${vmsId}';
	var userName = '${userName}';
	
	window.onload = function(){
		stomp.connect({}, function(){
			stomp.subscribe("/sub/chat/room/" + vmsId, function(control){
				var content = JSON.parse(control.body);
				var writer = content.writer;
				var vmsId = content.vmsId;
				var msg = content.message;
				if(userName != writer){
					alert('메시지 수신 \n 송신 : '+ writer + '\n' + 'VMS ID : ' + vmsId + '\n' + '메시지 : ' + msg);
				}
			});
		});
	}
	
	const enterBt = document.getElementById("send-bt"); 
	
	enterBt.addEventListener('click', () => {
		var msg = document.getElementById('inputMessage').value;
		stomp.send('/pub/chat/message', {}, JSON.stringify({vmsId : vmsId, message: msg, writer : userName}));
	});
	
</script>
</html>