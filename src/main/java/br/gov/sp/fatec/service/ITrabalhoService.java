package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.entity.trabalho;

public interface ITrabalhoService {
    List<trabalho> buscarPorPalavraETNota(String palavraChave, Integer notaMinima) ;
}
