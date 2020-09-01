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
                    
                    
                    ::placeholder{
                        font-size: 18px;
                        line-height: 150%;
                        color: #090C00;
                    }
			
			
		</style>

</head>

<body>
    <c:if test="${logado.acesso != 2}">
        <c:redirect url="/"/>
                    </c:if>
	 <%@ include file="../../../components/header.jsp" %> 
	<section class="form">
		
		 <h1>Produto</h1>
        <form action="${linkTo[ProdutosController].salvar}" method="post">
            <label for="descricao">Descrição</label>
            <input type="text" name="produto.descricao" >
             <label for="imagem">Imagem</label>
            <input type="text" name="produto.imagem" >
             <label for="valor">Valor</label>
	 <input type="number" name="produto.valor" >
				
            <input type="submit" class="button" value="Enviar">
            
        </form>


		
	</section>

</body>

</html>