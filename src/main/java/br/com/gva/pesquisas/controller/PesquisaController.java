package br.com.gva.pesquisas.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.pesquisas.model.dto.PesquisaInserirDTO;
import br.com.gva.pesquisas.model.dto.PesquisaListaDTO;
import br.com.gva.pesquisas.model.dto.PesquisaSalvaDTO;
import br.com.gva.pesquisas.model.entidade.Pesquisa;
import br.com.gva.pesquisas.model.enums.GeneroFilme;
import br.com.gva.pesquisas.service.PesquisaService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RequestMapping("/pesquisas")
@Controller
public class PesquisaController {

    @Autowired
    private PesquisaService service;


    @GetMapping("/form-pesquisa")
    public String carregaPaginaDeInsercao(@PathParam("id") Integer id ,Model model){
        if(Objects.nonNull(id)){
            Pesquisa pesquisa = service.procurarPeloId(id);
            model.addAttribute("pesquisa", pesquisa);
            model.addAttribute("generoFilme", GeneroFilme.class);
            return "inserir-pesquisa";
        }
        model.addAttribute("pesquisa", new Pesquisa());
        model.addAttribute("generoFilme", GeneroFilme.class);
        return "inserir-pesquisa";
    }

    @PostMapping("/salvar")
    public String novaPesquisa(@ModelAttribute("pesquisa") @Valid PesquisaInserirDTO pesquisa, BindingResult result){
        if(!result.hasErrors() && (Objects.isNull(pesquisa.getId()))){
            PesquisaSalvaDTO pesquisaSalva = service.salvar(pesquisa);
            pesquisa.setId(pesquisaSalva.getId());
            return "redirect:/pesquisas/form-pesquisa?id=" + pesquisa.getId();  
        }

        if(!result.hasErrors() && (Objects.nonNull(pesquisa.getId()))){
            PesquisaSalvaDTO pesquisaSalva = service.salvar(pesquisa);
            pesquisa.setId(pesquisaSalva.getId());
            return "redirect:/pesquisas/form-pesquisa?id=" + pesquisa.getId();
        }
        return "/inserir-pesquisa";
    }

    @GetMapping
    public String listarTodasPesquisas(Model model){
        List<PesquisaListaDTO> pesquisas =  service.listarTodasPesquisas();
        model.addAttribute("pesquisas", pesquisas);
        return "listar-pesquisas";
    }

    @GetMapping("/remover")
    public String procurarPeloId(@PathParam("id") Integer id) {
        service.deleteById(id);
        return "redirect:/pesquisas";
    }    
}