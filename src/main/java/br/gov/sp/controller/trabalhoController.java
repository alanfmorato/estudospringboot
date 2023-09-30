package br.gov.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.entity.trabalho;
import br.gov.sp.fatec.service.ITrabalhoService;

@RestController
@CrossOrigin
@RequestMapping(value = "trabalho")
public class trabalhoController {

    @Autowired
    private ITrabalhoService service;

    @GetMapping("/buscarTrabalhos")
    public List<trabalho> buscarTrabalhosPorPalavraENota(
            @PathVariable("palavraChave") String palavraChave,
            @PathVariable("nota") int notaMinima) {
        return service.buscarPorPalavraETNota(palavraChave, notaMinima);
    }

    @RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    private final trabalhoService trabalhoService;

    @Autowired
    public TrabalhoController(trabalhoService trabalhoService) {
        this.trabalhoService = trabalhoService;
    }

    @GetMapping("/buscarPorPalavraENota")
    public List<trabalho> buscarTrabalhosPorPalavraENota(
            @RequestParam String palavraChave,
            @RequestParam Integer notaMinima) {
        return trabalhoService.buscarPorPalavraENota(palavraChave, notaMinima);
    }

    @GetMapping("/{id}")
    public trabalho buscarTrabalhoPorId(@PathVariable Long id) {
        return trabalhoService.buscarPorId(id);
    }

    @PostMapping("/novo")
    public trabalho criarNovoTrabalho(@RequestBody trabalho trabalho) {
        return trabalhoService.salvarTrabalho(trabalho);
    }

    @GetMapping("/todos")
    public List<trabalho> buscarTodosTrabalhos() {
        return trabalhoService.buscarTodos();
    }
    
}
