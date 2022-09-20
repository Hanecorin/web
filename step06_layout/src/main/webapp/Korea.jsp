<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Korea.jsp</title>
	
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--  외부 css 파일을 include -->
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>playdata</h2>
<p>서초와 독산에서 교육중!</p>


<header>
  <h2>Cities</h2>
</header>

<section>
  <nav>
	<jsp:include page="nav.jsp"/>
  </nav>
  
  <article>
    <h1>Korea</h1>
    <p>한국의 서울</p>
    <p>index.html 첫 화면 입니다.</p>
  </article>
</section>

<footer>
  <p>Footer</p>
</footer>

</body>
</html>
