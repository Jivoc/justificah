package progweb.prova01.repository.helper;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import progweb.prova01.model.Justificativa;
import progweb.prova01.model.Situacao;

public class JustificativaQueriesImpl implements JustificativaQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public List<Justificativa> buscarComCidadaoEleicao(Situacao situacao) {
		String jpql = "select j from Justificativa j inner join fetch j.cidadao where j.situacao = :situacao";
		TypedQuery<Justificativa> query = manager.createQuery(jpql, Justificativa.class);
		query.setParameter("situacao", situacao);
		List<Justificativa> justificativas = query.getResultList();
		jpql = "select j from Justificativa j inner join fetch j.eleicao where j in :justificativas";
		query = manager.createQuery(jpql, Justificativa.class);
		query.setParameter("justificativas", justificativas);
		justificativas = query.getResultList();
		return justificativas;	
	}

	@Override
	@Transactional
	public Justificativa buscarComCidadaoEleicao(Long codigo) {
		String jpql = "select j from Justificativa j inner join fetch j.cidadao where j.codigo = :codigo";
		TypedQuery<Justificativa> query = manager.createQuery(jpql, Justificativa.class);
		query.setParameter("codigo", codigo);
		Justificativa justificativa = query.getSingleResult();
		jpql = "select j from Justificativa j inner join fetch j.eleicao where j in :justificativa";
		query = manager.createQuery(jpql, Justificativa.class);
		query.setParameter("justificativa", justificativa);
		justificativa = query.getSingleResult();
		return justificativa;	
	}

}
