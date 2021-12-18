<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body style="background:threeddarkshadow;">

	<jsp:include page="partials/nav.jsp"></jsp:include>

	<div class="col-lg-5 mx-auto p-3 py-md-5" >

		<main >
			
			<div class="container" >
				<h1 >
					¡ Hola <c:out value="${user.username}" /> !
				</h1>
			</div>

			<!--  Carousel de Atracciones  -->
			<section >
				<div id="AtraccionesCarousel" class="carousel slide carousel-fade"
					data-bs-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="assets\img\1LaComarca.jpg" class="d-block w-100">
						</div>
						<div class="carousel-item">
							<img src="assets\img\2Lotr.jpg" class="d-block w-100">
						</div>
						<div class="carousel-item">
							<img src="assets\img\3lothlorien.jpg" class="d-block w-100">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#AtraccionesCarousel" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden"></span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#AtraccionesCarousel" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden"></span>
					</button>
				</div>
			</section>


		</main>
	</div>
</body>
<footer>
	<jsp:include page="partials/footer.jsp"></jsp:include>
</footer>
</html>