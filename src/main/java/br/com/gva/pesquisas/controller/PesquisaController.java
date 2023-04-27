package br.com.gva.pesquisas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.gva.pesquisas.model.dto.PesquisaInserirDTO;
import br.com.gva.pesquisas.model.entidade.Pesquisa;
import br.com.gva.pesquisas.model.enums.GeneroFilme;
import br.com.gva.pesquisas.service.PesquisaService;
import jakarta.validation.Valid;

@Controller
public class PesquisaController {

    @Autowired
    private PesquisaService service;

    @GetMapping("/home")
    public String carregaHome(){
        return "index";
    }

    @GetMapping("/form-pesquisa")
    public String carregaPaginaDeInsercao(Model model){
        model.addAttribute("pesquisa", new Pesquisa());
        model.addAttribute("generoFilme", GeneroFilme.class);
        return "inserir-pesquisa";
    }

    @PostMapping("/salvar")
    public String novaPesquisa(@ModelAttribute("pesquisa") @Valid PesquisaInserirDTO pesquisa, Errors errors, Model model){
        if(!errors.hasErrors()){
            service.salvar(pesquisa);
        }
        return "inserir-pesquisa";
    }
    
}