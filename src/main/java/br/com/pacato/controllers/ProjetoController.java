package br.com.pacato.controllers;

import br.com.pacato.models.Projeto;
import br.com.pacato.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProjetoController{

    @Autowired
    private ProjetoRepository projetoRepository;

    //MÉTODO GET PARA LISTAR 7 PROJETOS E ORDENAR POR DATA MAIS RECENTE
    @GetMapping("/projetos")
    public ModelAndView listaProjetos(){
        ModelAndView mv = new ModelAndView("home/index");
        PageRequest paginacao =  PageRequest.of(0,7);
        List<Projeto> projetos = projetoRepository.findByDataSolicitacao(paginacao);
        mv.addObject("projetos",projetos);
        return mv;
    }

    //MÉTODO GET PARA LISTAR TODOS OS PROJETOS CADASTRADO
    @GetMapping("/listaTodosProjetos")
    public ModelAndView listaTodosProjetos(){
        ModelAndView mv = new ModelAndView("home/index");
        List<Projeto> projetos = projetoRepository.findByDataSolicitacao();
        mv.addObject("projetos",projetos);
        return mv;
    }

    //MÉTODO GET PARA CADASTRAR UM NOVO PROJETO
    @GetMapping("/cadastrarProjeto")
    public ModelAndView cadastrarProjeto(Projeto projeto) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("projeto/formProjeto");
        //mv.addObject("projeto", new Projeto());
        return mv;
    }

    //MÉTODO POST PARA CADASTRAR UM NOVO PROJETO
    @PostMapping("novoProjeto")
    public ModelAndView cadastrarProjeto(@Valid Projeto projeto, BindingResult br, RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView();
        if(br.hasErrors()) {
            mv.setViewName("projeto/form-projeto");
            mv.addObject("projeto");
        } else {
            projetoRepository.save(projeto);
            attributes.addFlashAttribute("mensagem", "Projeto " + projeto.getNomeProjeto() + " cadastrado com sucesso!");
            mv.setViewName("redirect:/projetos");
        }
        return mv;
    }

    //MÉTODO GET PARA ATUALIZAR UM  PROJETO  CADASTRADO  POR ID
    @GetMapping("/atualizarProjeto/{id}")
    public ModelAndView atualizarProjeto(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("projeto/atualizar-projeto");
        Projeto projeto = projetoRepository.getOne(id);
        mv.addObject("projeto", projeto);
        return mv;
    }

    //MÉTODO POST PARA ATUALIZAR O  PROJETO
    @PostMapping("/atualizar")
    public ModelAndView atualizar(@Valid Projeto projeto, BindingResult br,RedirectAttributes attributes ) {
        ModelAndView mv = new ModelAndView();
        if(br.hasErrors()) {
            mv.setViewName("projeto/atualizar-projeto");
            mv.addObject("projeto");
        } else {
            projetoRepository.save(projeto);
            mv.setViewName("redirect:/");
            attributes.addFlashAttribute("mensagem", "Projeto de id "+ projeto.getId() +" atualizado com sucesso!");
        }
        return mv;
    }

    //MÉTODO GET PARA DELETAR UM PROJETO POR ID
    @GetMapping("/deletar/{id}")
    public String deletarProjeto(@PathVariable("id") Long id, RedirectAttributes attributes, Projeto projeto) {
        projetoRepository.deleteById(id);
        attributes.addFlashAttribute("mensagem", "Projeto de id "+ id +" deletado com sucesso!");
        return "redirect:/projetos";
    }

    //MÉTODO GET PARA VISUALIZAR DETALHES DE UM PROJETO
    @GetMapping("/{id}")
    public ModelAndView detalhesProjeto(@PathVariable("id") Long id){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        ModelAndView mv = new ModelAndView("projeto/detalhes-projeto");
        mv.addObject("projetos", projeto);
        return mv;
    }

    //MÉTODO GET PARA FILTRAR PROJETOS POR REGULATÓRIO
    @GetMapping("filtrarProjetos")
    public ModelAndView filtroProjetos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("projeto/filtrar-projetos");
        return mv;
    }

    //MÉTODO GET PARA LISTAR TODOS OS PROJETOS CADASTRADOS  COM REGULATÓRIO SIM
    @GetMapping("projetosRegulatorioSim")
    public ModelAndView listaProjetosRegularioSim(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("projeto/projetos-regulatorio-sim");
        mv.addObject("projetosRegulatorioSim",projetoRepository.findByRegulatorioSim());
        return mv;
    }

    //MÉTODO GET PARA LISTAR TODOS OS PROJETOS CADASTRADOS  COM REGULATÓRIO NAO
    @GetMapping("projetosRegulatorioNao")
    public ModelAndView listaProjetosRegularioNao(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("projeto/projetos-regulatorio-nao");
        mv.addObject("projetosRegulatorioNao",projetoRepository.findByRegulatorioNao());
        return mv;
    }

    //MÉTODO POST PARA PESQUISAR PROJETO POR NOME
    @PostMapping("/pesquisarProjetoPorNome")
    public ModelAndView pesquisar(@RequestParam(value = "nomepesquisa", required = false) String nomeProjeto) {
        ModelAndView mv = new ModelAndView("home/index");
        if(nomeProjeto == null || nomeProjeto.trim().isEmpty()) {
            mv.addObject("projetos", projetoRepository.findByDataSolicitacao());
        } else {
            mv.addObject("projetos", projetoRepository.findByNomeProjetoContainingIgnoreCase(nomeProjeto));
        }
        return mv;
    }

   //MÉTODO GET PARA PESQUISAR PROJETO POR ID
    @PostMapping("pesquisarProjetoPorId")
    public ModelAndView pesquisarId(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView mv = new ModelAndView("home/index");
        //mv.addObject("projetos", projetoRepository.getOne(id));
        Optional<Projeto> byId = projetoRepository.findById(id);
        if (byId.isPresent()) {
            Projeto projeto = byId.get();
            mv.addObject("projetos", projeto);
        }
        mv.addObject("projetos", projetoRepository.findByDataSolicitacao());
        return mv;
    }

}

