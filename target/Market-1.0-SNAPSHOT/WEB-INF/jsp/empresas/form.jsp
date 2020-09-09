
            
                <div id="Empresa" class="tabcontent">

            <form action="${linkTo[EmpresasController].salvar}" method="post">
            <input type="hidden" name="empresa.id" value="${empresa.id}">
            <label for="nome">CNPJ</label>
            <input id="cnpj" type="text" name="empresa.cnpj">
            <label for="nome">Nome</label>
            <input id="nome" type="text" name="empresa.nome">
            <label for="nome">Email</label>
            <input type="text" name="empresa.email" >
            <label for="nome">Senha</label>
            <input type="password" name="empresa.senha" >
            <input type="submit" class="button" value="Enviar">
   
        </form>
                </div>

                
          
