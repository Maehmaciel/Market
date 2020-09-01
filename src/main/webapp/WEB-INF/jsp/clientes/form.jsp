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




#cad{
    margin: 0;
    font-family: Arial;
    display:flex;
  flex-direction:column;
  align-items: center;
  justify-content: center;
   

  
  
}

.links{
  display:flex;
  }
.aba {
    background-color: #555;
    color: white;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 17px;
    min-width: 25vh;
     box-shadow: 0 4px 6px 0 rgba(31,70,88,0.4);
  }
  
  
  .tabcontent {
    background-color: white;
    display: none;
    min-height: 50vh;
    min-width: 50vh;
    opacity: 0.85;
    display:flex;
    align-items: center;
    justify-content: center;
     box-shadow: 0 4px 6px 0 rgba(31,70,88,0.4);
  }
  


form{
  display: flex;
  flex-direction: column;
}

input{
 padding: 10px;
 margin: 5px 0px;

}

			
		</style>

</head>

<body>
	
        <%@ include file="../../../components/header.jsp" %> 
 
            <section id="cad" class="form">
            <div class="links">
                <button class="aba" onclick="abrir('Pessoa', this)" id="pessoa">CPF</button>
                <button class="aba" onclick="abrir('Empresa', this)" id="empresa" >CNPJ</button>
            </div>
            <div class="forms">
                <%@ include file="../pessoas/form.jsp" %> 

               <%@ include file="../empresas/form.jsp" %> 
            </div>

        </section>
                    <script>
                        function abrir(pageName,elmnt,color) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("aba");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }
  document.getElementById(pageName).style.display = "flex";
  elmnt.style.backgroundColor = 'black';
}


                document.getElementById("empresa").click();
                    </script>
</body>

</html>