<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>squid cache 테스트</title>
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
  						<img src="/img/large.jpg" class="card-img-top" alt="...">
  						<div class="card-body">
    						<h5 class="card-title">Card title</h5>
    						<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    						<a href="#" class="btn btn-primary">Go somewhere</a>
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
	/*function enterRoom(vmsId){
		//var userName = document.getElementById('userName').value;
		var vmsIdNode = document.getElementById(vmsId);
		var userName = vmsIdNode.previousElementSibling.value;
		
		var url = '/squid/test/' + vmsId + '/' + userName;
		var name = 'VMS 제어팝업';
		var option = "width = 800, height = 800, top = 100, left = 200, location = no";
		window.open(url, name, option);
		
	}*/

</script>
</html>