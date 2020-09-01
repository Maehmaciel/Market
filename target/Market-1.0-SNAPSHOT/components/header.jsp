        <header>
            <a href="${pageContext.request.contextPath}/"><h1>Market</h1></a>
		<div>
                    <c:if test="${not empty logado}">
        <div class="dropdown">
       <a class="user">${logado.nome}</a>
 
  <div class="dropdown-content">
  <a href="${pageContext.request.contextPath}/vendas/lista">Compras</a>
  <a href="${pageContext.request.contextPath}/logout">Sair</a>
  </div>
</div>
    </c:if>
            <c:if test="${empty logado.nome}">
       <div class="visita">
            <a class="button" href="${pageContext.request.contextPath}/login">Login</a>
            <a class="link" href="${pageContext.request.contextPath}/cadastro">Cadastro</a>
       </div>
    </c:if>
			
			
			<a class="icon" href="${linkTo[ItensController].lista()}">
				<img src="${pageContext.request.contextPath}/assets/ic_cart.svg">
			</a>
		</div>

	</header>