<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="en">

    <head>
    <metbutton charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link hrbuttonf="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../css/main.css">
        <title>Document</title>
        <style>
            #tabelaProdutos {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                margin: 10px;
            }

            #tabelaProdutos td, #tabelaProdutos th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #tabelaProdutos tr:nth-child(even){background-color: #f2f2f2;}

            #tabelaProdutos tr:hover {background-color: #ddd;}

            #tabelaProdutos th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            }   
            
            .venda{
                margin: 10px;
                border: solid 1px;
                padding: 10px
            }
        </style>
    </head>

    <body>
        <%@ include file="../../../components/header.jsp" %> 

        <c:if test="${logado.acesso == 2}">
            <c:forEach items="${vendaList}" var="venda_cliente">
                <div class="venda">
                     <h2>Data: ${venda_cliente.data}</h2>
                <p>Cliente: ${venda_cliente.cliente.nome}</p>
                <table id="tabelaProdutos">
                    <tr>
                        <th>Produto</th>
                        <th>Preço</th>
                        <th>Quantidade</th>
                    </tr>

                    <c:forEach items="${venda_cliente.itens}" var="item_venda">

                        <tr>
                            <td>${item_venda.produto.descricao}</td>
                             <td>${item_venda.produto.valor}</td>
                            <td>${item_venda.qtd} un</td>

                        </tr>                   
                    </c:forEach>

                </table>
                <h3>Total: R${venda_cliente.total()}</h3>
                </div>
                
            </c:forEach>
        </c:if>

        <c:if test="${logado.acesso == 1}">
            <c:forEach items="${logado.vendas}" var="venda_cliente">
                <div class="venda">
                     <h2>Data: ${venda_cliente.data}</h2>
                <p>Cliente: ${venda_cliente.cliente.nome}</p>
                <table id="tabelaProdutos">
                    <tr>
                        <th>Produto</th>
                        <th>Preço</th>
                        <th>Quantidade</th>
                    </tr>

                    <c:forEach items="${venda_cliente.itens}" var="item_venda">

                        <tr>
                            <td>${item_venda.produto.descricao}</td>
                             <td>${item_venda.produto.valor}</td>
                            <td>${item_venda.qtd} un</td>

                        </tr>                   
                    </c:forEach>

                </table>
                <h3>Total: R${venda_cliente.total()}</h3>
                </div>
               
            </c:forEach>
        </c:if>




    </body>

</html>