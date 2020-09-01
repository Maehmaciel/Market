
            
                <div id="Pessoa" class="tabcontent">

            <form action="${linkTo[PessoasController].salvar}" method="post">
            <input type="hidden" name="pessoa.id" value="${pessoa.id}">
            <label for="nome">CPF</label>
            <input id="cpf" type="text" name="pessoa.cpf">
            <label for="nome">Nome</label>
            <input id="nome" type="text" name="pessoa.nome">
            <label for="nome">Email</label>
            <input type="text" name="pessoa.email" >
            <label for="nome">Senha</label>
            <input type="password" name="pessoa.senha" >
            <input type="submit" class="button" value="Enviar">
            <c:forEach var="error" items="${errors}">
    ${error.category} ${error.message}<br />
</c:forEach>
        </form>
                </div>

                
          
