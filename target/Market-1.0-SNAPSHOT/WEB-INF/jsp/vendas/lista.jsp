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
	
</head>

<body>
	<%@ include file="../../../components/header.jsp" %> 
       
        <c:if test="${logado.acesso == 2}">
            <c:forEach items="${vendaList}" var="venda">
                <p>${venda.data}</p>
                <p>${venda.id}</p>
                <p>${venda.itens}</p>
                        
                    </c:forEach>
        </c:if>
        
           <c:if test="${logado.acesso == 1}">
           <c:forEach items="${logado.vendas}" var="venda">
                        <p>${venda}</p>
                        
                    </c:forEach>
        </c:if>
                                
                    
	

</body>

</html>