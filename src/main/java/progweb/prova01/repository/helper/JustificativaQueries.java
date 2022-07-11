package progweb.prova01.repository.helper;

import java.util.List;

import progweb.prova01.model.Justificativa;
import progweb.prova01.model.Situacao;

public interface JustificativaQueries {

	public List<Justificativa> buscarComCidadaoEleicao(Situacao situacao);
	public Justificativa buscarComCidadaoEleicao(Long codigo);
	
}
