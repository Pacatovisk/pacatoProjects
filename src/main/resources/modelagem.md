Atividade - CRUD de projetos:


Objetivo principal: Fazer operações de insert, update, delete e selects para projetos.


Atributos da entidade projeto:

    - Id (Long);
    - Nome do Projeto (String);
    - Departamento (String ou Entidade);
    - Data Solicitacao (LocalDate);
    - Regulatório (enum - sim ou nao);
    - Análise Situação Atual (String);
    - Descrição Situação Desejada (String);
    - Descrição Solução (String);
    
O que fazer?
    
    1)Listagem de todos projetos
    2)Ver detalhes de um projeto
    3)Editar projeto
    4)Deletar um projeto
    5)Inserir um projeto
    
    *Opicional:
    
    6)Fazer input para pesquisar projeto por id/nome
    7)Após um projeto for editado, deletado ou alterado, 
      mostrar um alert dizendo que operação foi concluída
    8)Filtrar projetos que tenham regulatório sim/não
    9)Ordenar projetos por data solicitação mais recente 
      pra mais antiga
    10)Quando deletar um projeto, pedir pro usuario 
      digitar algo (por exemplo uma senha)
    11)Fazer validação com o Validation 
    12)Fazer o CRUD com departamentos 
    
    





















//
//    @PostMapping("pesquisarProjetoPorId")
//    public ModelAndView pesquisarId(@RequestParam(value = "id", required = false) Long id) {
//        ModelAndView mv = new ModelAndView("home/index");
//        //mv.addObject("projetos", projetoRepository.getOne(id));
//        Optional<Projeto> byId = projetoRepository.findById(id);
//
//
//        if (byId.isPresent()) {
//            Projeto projeto = byId.get();
//            mv.addObject("projetos", projeto);
//        }
//
//        mv.addObject("projetos", projetoRepository.findByDataSolicitacao());
//        return mv;
//    }
    
    
  
<!--&lt;!&ndash; Button trigger modal &ndash;&gt;-->
<!--<a class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#exampleModal"-->
<!--   th:attr="data-target='#modal-warning'+${projeto.id}">-->
<!--    <span class="glyphicon glyphicon-trash"><i class="bi bi-trash"></i></span>-->
<!--</a>-->
<!--&lt;!&ndash; Modal &ndash;&gt;-->
<!--<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">-->
<!--    <div class="modal-dialog" th:id="modal-warning+${projeto.id}">-->
<!--        <div class="modal-content">-->
<!--            <div class="modal-header text-center">-->
<!--                <h3 class="modal-title text-light bg-dark text-center titulo-painel"  id="exampleModalLabel">Deletar Projeto</h3>-->
<!--                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
<!--            </div>-->
<!--            <div class="modal-body text-center">-->
<!--                <h4>Tem certeza que deseja deletar o projeto?</h4>-->
<!--            </div>-->
<!--            <div class="modal-footer">-->
<!--                <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Fechar</button>-->
<!--                <a type="button" class="btn btn-outline-danger" th:href="@{deletar/{id}(id=${projeto.id})}"><i class="fa fa-check"></i>&nbsp;Excluir Projeto</a>-->
<!--            </div>-->
<!--        </div>-->
<!--    </div>-->
<!--</div>-->

    
    