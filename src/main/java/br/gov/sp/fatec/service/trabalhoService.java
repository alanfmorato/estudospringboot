package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.entity.trabalho;
import br.gov.sp.fatec.repository.trabalhoRepository;

@Service
public class trabalhoService implements ITrabalhoService{
    @Autowired
    private trabalhoRepository trarepo;

    public List<trabalho> buscarPorPalavraETNota(String palavraChave, Integer notaMinima) {
        return trarepo.findByTituloContainingAndNotaGreaterThanAndJustificativaIsNotNull(palavraChave, notaMinima);
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



}
