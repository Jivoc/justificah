package progweb.prova01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import progweb.prova01.model.Juiz;
import progweb.prova01.model.Situacao;

public interface JuizRepository  extends JpaRepository<Juiz, Long> {

	public List<Juiz>findBySituacaoNot(Situacao situacao); 
	
}	