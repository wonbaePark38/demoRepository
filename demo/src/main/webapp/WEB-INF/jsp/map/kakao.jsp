<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>지도테스트</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fe3feed1a2f9beea8d84e277d5a88d05"></script>
</head>
<body style="width:100vw; height:100vh; vertical-align: middle; display: table-cell;">
	<div id="map" style="width:100%;height:500px;"></div>
</body>

<script>
var mapContainer = document.getElementById('map'),
mapOption = {
	center: new kakao.maps.LatLng(37.566826, 126.9786567),
	level: 3
};

var map = new kakao.maps.Map(mapContainer, mapOption);
console.log(map);
window.onload = function(){
	/*var infowindow = new kakao.maps.InfoWindow({
		zindex: 1
	});*/
	
	
}
</script>
</html>