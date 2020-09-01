<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="en">

<head>
	<metbutton charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link hrbuttonf="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
		<title>Document</title>
		<style>
			.carrinho {
				padding: 50px;
				max-width: 90vw;
				margin: 0 auto;
				min-height: calc(100vh - 88px);
				display: flex;
				flex-direction: column;
				justify-content: space-between;

			}

			.carrinho .itemCarrinho {
				display: flex;
				font-size: 18px;
				line-height: 150%;
				color: #545454;
				justify-content: space-around;
				align-items: center;
                                padding: 20px 0px;
			}

			.carrinho .imgProduto {
				height: 60px;
				width: 60px;
				border: solid 2px #A5C135;
			}
                        
                        .carrinho .itens p{
                            min-width: 100px;
                        }

			

			.total {
				margin: 20px 0px;
			}

			.total h2 {
				font-weight: 600;
				font-size: 22px;
				line-height: 130%;
				color: #090C00;
			}

			.total p {
				font-weight: 500;
				font-size: 14px;
				line-height: 17px;
				color: #545454;
			}

			.total span {
				font-weight: 600;
				font-size: 40px;
				line-height: 150%;
				color: #090C00;
			}

			.total .button {
				padding: 15px 50px;
			}
		</style>

</head>

<body>
	<%@ include file="../../../components/header.jsp" %> 
	<section class="carrinho">
		<section class="itens">
			
                                        <c:forEach items="${venda.itens}" var="item" varStatus="loop">
                                           <div class="itemCarrinho">
				<div class="imgProduto">
					<img src="${pageContext.request.contextPath}/assets/${item.produto.imagem}">
				</div>

				<p>${item.produto.descricao}</p>
				<p>Valor: R$ ${item.produto.valor}</p>
				<label for="qtd">
                                    <input id="qtd${loop.index}" class="qtd" min="1" onchange="getComboA(this)" value="${item.qtd}" type="number"  />
				</label>
				<button class="icon" href="carrinho.html">
					<img src="${pageContext.request.contextPath}/assets/ic_close.svg">
				</button>
			</div>
                                        </c:forEach>
                                        

		</section>

		<section class="total">
			<div>
				<h2>Valor da Compra</h2>
				<p>*É nescessario login para realizar a compra.</p>
                                <span>R$ ${venda.total()}</span>
			</div>
                                <c:if test="${not empty logado.nome}">
                                    <a class="button" href="${pageContext.request.contextPath}/comprar">Comprar</a>
                                </c:if>
                        
		</section>
	</section>
                <script>
                    function getComboA(sel) {
            
    window.location.replace('/Market/qtd/'+sel.id.split("qtd")[1]+'/'+sel.value)
}
                </script>

</body>

</html>