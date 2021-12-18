<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container">
		
		<!-- <img src="assets\img\ring.jpg" class="img-thumbnail"> -->
		
		<a class="navbar-brand" href="/TP-Park/index.jsp">Turismo en la Tierra Media</a>
		
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" 
					   href="/TP-Park/attractions/index.do">Atracciones
					</a>
				</li>				
			</ul>
			
			<c:if test="${user.isAdmin()}">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" 
					   href="/TP-Park/users/index.do">Usuarios
					</a>
				</li>				
			</ul>										
			</c:if>
			
			
			
			<ul class="navbar-nav">				
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" 
					 href="#" id="navbarDropdown" role="button"
					 data-bs-toggle="dropdown" aria-expanded="false">
						<c:if test="${user.isAdmin()}">
							<c:out value="Administrador "></c:out>							
						</c:if>
						<c:out value="${user.username}"></c:out>
					</a>
					
					
					
					<c:if test="${!user.isNull()}">
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="navbarDropdown" 
							style="background-color: black"> 							
						
							<li><a class="dropdown-item disabled" style="color: gold;">
							<i title="monedas" style="color: gold;" class="bi bi-cash-coin"></i> 
							<c:out value="${user.coins}"></c:out>
								</a>
							</li>
							
							<li><a class="dropdown-item disabled" style="color: silver;">
									<i title="tiempo" style="color: silver;" class="bi bi-hourglass-split"></i> 
									<c:out value="${user.time}"></c:out>
								</a>
							</li>
													
							<li><hr class="dropdown-divider">
							</li>						
						
							<li><a href="/TP-Park/logout" class="dropdown-item" 
								style="color: red;">Cerrar Sesión</a>
							</li>
						</ul>						
					</c:if>
							
												
					<%-- <c:if test="${user.isNull()}">
						<li><a href="/TP-Park/logout" class="dropdown-item" 
								style="color: red;">Cerrar Sesión</a>
						</li>			
					</c:if> --%>				
				</li>				
			</ul> 			
		</div>
	</div>
</nav>

