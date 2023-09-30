package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.entity.trabalho;

public interface trabalhoRepository extends JpaRepository<trabalho, Long> {
    
    List<trabalho> findByTituloContainingAndNotaGreaterThanAndJustificativaIsNotNull(String palavraChave, Integer notaMinima);
}
