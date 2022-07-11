package progweb.prova01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import progweb.prova01.model.Justificativa;
import progweb.prova01.repository.helper.JustificativaQueries;

public interface JustificativaRepository  extends JpaRepository<Justificativa, Long>, JustificativaQueries {

}
