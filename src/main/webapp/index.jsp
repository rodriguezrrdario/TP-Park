<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partials/nav.jsp"></jsp:include> 
	
	<div class="col-lg-5 mx-auto p-3 py-md-5">

		<main>			
			<div class="container"> 
				<h1>
					¡ Hola <c:out value="${user.username}" /> !
				</h1>
			</div>
			
			
		</main>
	</div>
</body>
</html>