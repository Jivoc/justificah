package progweb.prova01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import progweb.prova01.model.Eleicao;
import progweb.prova01.model.Situacao;

public interface EleicaoRepository extends JpaRepository<Eleicao, Long> {

	public List<Eleicao>findBySituacaoNot(Situacao situacao);
	
}
