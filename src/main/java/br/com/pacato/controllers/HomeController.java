package br.com.pacato.controllers;

import br.com.pacato.models.Projeto;
import br.com.pacato.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private  ProjetoRepository projetoRepository;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home/index");
        PageRequest paginacao =  PageRequest.of(0,7);
        List<Projeto> projetos = projetoRepository.findByDataSolicitacao(paginacao);
        mv.addObject("projetos",projetos);
        return mv;
    }
}
