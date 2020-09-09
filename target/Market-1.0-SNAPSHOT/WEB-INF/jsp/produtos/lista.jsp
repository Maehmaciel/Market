<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/Market/css/main.css">
        
	<title>Document</title>
	<style>
		.produtos {
			display: flex;
			padding: 50px;
			max-width: 90vw;
		}

		.produtos>div {
			display: flex;
			max-width: 90vw;
			flex-wrap: wrap;
		}

		.produtos .imgProduto {
			height: 320px;
			width: 280px;
			border: solid 5px #A5C135;
		}

		.produto {
			margin: 20px;
			display: flex;
			flex-direction: column;
		}

		.produto p {
			font-size: 24px;
			line-height: 130%;
			color: #545454;
			margin: 16px 0px;
		}

		.produto span {
			font-weight: 600;
			font-size: 28px;
			line-height: 135%;
			color: #090C00;
		}


		@media (max-width: 950px) {}

		@media (max-width: 350px) {}
	</style>

</head>

<body>
    
	        <%@ include file="../../../components/header.jsp" %> 

	<section class="produtos">
		<div>
                    <c:if test="${produtoList.size() == 0}">
                        <p>Sinto Muito, não ha produtos cadastrados</p>
                    </c:if>
                    <c:forEach items="${produtoList}" var="produto">
                        <div class="produto">
				<div class="imgProduto">
					<img src="${pageContext.request.contextPath}/assets/${produto.imagem}">
				</div>
                                           
				<p>${produto.descricao}</p>
				<span>Valor: R$ ${produto.valor}</span>
                  
                           <a class="button buy" id="produto${produto.id}" onclick="carrinho(${produto.id})" >Comprar</a>
			</div>
                    </c:forEach>
      
      <c:if test="${logado.acesso==2}">
          <c:redirect url = "produtos/form"/>
    </c:if>
			
                        
                     
		</div>
            
	</section>
                
                <script>
                  <c:forEach items="${venda.itens}" var="item" varStatus="loop">
         
         
                                selecionado(${item.produto.id})
                                        </c:forEach>      
                    document.querySelectorAll('.buy').forEach(item => {
  item.addEventListener('click', event => {
      event.preventDefault()
    
  })
})
function carrinho(id) {
   
  window.location.href="${pageContext.request.contextPath}/add/"+id
 
}

function selecionado(id) {
   
   let e=document.getElementById('produto'+id)
  e.removeAttribute("onclick"); 
  e.style.backgroundColor="green"
  e.innerHTML="Selecionado"
  
  console.log(e)
}
</script>
</body>

</html>