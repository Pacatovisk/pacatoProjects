package br.com.pacato.services;

import br.com.pacato.enums.Regulatorio;
import br.com.pacato.models.Projeto;
import br.com.pacato.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public void instanciaBaseDeDados() {
        Projeto projeto1 = new Projeto(null, "Sustentação","Desenvolvimento", LocalDate.of(2020, 5, 20), Regulatorio.SIM, "Concluído", "Acerto", "Arrumar bugs do sistema interno.");
        Projeto projeto2 = new Projeto(null,"Banco", "Administração",LocalDate.of(2009, 10, 20), Regulatorio.SIM, "Análise", "Acerto", "Melhoraria nos processos de fluxo de informações");
        Projeto projeto3 = new Projeto(null, "Suporte","Suporte Técnico",LocalDate.of(2021, 2, 11), Regulatorio.SIM, "Processando", "Acerto", "Melhorar atendimento");
        Projeto projeto4 = new Projeto(null,"Palestras" ,"Recursos Humanos",LocalDate.of(2021, 2, 13), Regulatorio.SIM, "Processando", "Acerto", "Paletras para os colaboladores");
        Projeto projeto5 = new Projeto(null, "Cartões","Contabilidade",LocalDate.now(), Regulatorio.SIM, "Processando", "Acerto", "Desconto nas parcelas");

        Projeto projeto6 = new Projeto(null, "Juridico","Juridico", LocalDate.now(), Regulatorio.NAO, "Concluído", "Acerto", "Arrumar bugs do sistema interno.");
        Projeto projeto7 = new Projeto(null,"Banco", "Administração",LocalDate.now(), Regulatorio.NAO, "Análise", "Acerto", "Melhoraria nos processos de fluxo de informações");
        Projeto projeto8 = new Projeto(null, "Contas","Contas a pagar",LocalDate.of(2021, 2, 14), Regulatorio.NAO, "Processando", "Acerto", "Melhorar atendimento");
        Projeto projeto9 = new Projeto(null,"Treinamentos" ,"Recursos Humanos",LocalDate.now(), Regulatorio.NAO, "Processando", "Acerto", "Paletras para os colaboladores");
        Projeto projeto10 = new Projeto(null, "Cartões","Contabilidade",LocalDate.now(), Regulatorio.NAO, "Processando", "Acerto", "Desconto nas parcelas");
        projetoRepository.saveAll(Arrays.asList(projeto1, projeto2, projeto3, projeto4, projeto5, projeto6, projeto7, projeto8, projeto9, projeto10));
    }
}
