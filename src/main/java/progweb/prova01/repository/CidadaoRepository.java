package progweb.prova01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import progweb.prova01.model.Cidadao;
import progweb.prova01.model.Situacao;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {

	public List<Cidadao>findBySituacaoNot(Situacao situacao);
	
}
