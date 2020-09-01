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
	 <%@ include file="../../../components/header.jsp" %> 
	<section class="form">
		
		 <h1>Cliente</h1>
        <form action="${linkTo[ClientesController].logar}" method="post">
            <label for="nome">Email</label>
            <input type="text" name="cliente.email" >
            <label for="nome">Senha</label>
            <input type="password" name="cliente.senha" >
            <input type="submit" class="button" value="Enviar">
            <c:forEach var="error" items="${errors}">
    ${error.category} ${error.message}<br />
</c:forEach>
        </form>


		
	</section>

</body>

</html>