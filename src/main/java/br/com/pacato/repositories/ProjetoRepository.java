package br.com.pacato.repositories;

import br.com.pacato.models.Projeto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query("select p from Projeto p where p.regulatorio = 'SIM' ")
    public List<Projeto> findByRegulatorioSim();

    @Query("select p from Projeto p where p.regulatorio = 'NAO' ")
    public List<Projeto> findByRegulatorioNao();

    @Query("select p from Projeto p ORDER BY p.dataSolicitacao  ASC")
    public List<Projeto> findByDataSolicitacao(Pageable sort);

    @Query("select p from Projeto p ORDER BY p.dataSolicitacao  ASC")
    public List<Projeto> findByDataSolicitacao();

    //consulta para pesquisar um projeto pelo nome
    //@Query("select p from Projeto p where p.nomeProjeto like %?1%")
    public List<Projeto> findByNomeProjetoContainingIgnoreCase(String nomeProjeto);

}
