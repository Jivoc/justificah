package progweb.prova01.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progweb.prova01.model.Justificativa;
import progweb.prova01.repository.JustificativaRepository;


@Service
public class JustificativaService {

	@Autowired
	private JustificativaRepository justificativaRepository;

	@Transactional
	public Justificativa salvar(Justificativa justificativa) {
		justificativa = justificativaRepository.save(justificativa);
		return justificativa;
	}

	@Transactional
	public Justificativa alterar(Justificativa justificativa) {
		justificativa = justificativaRepository.save(justificativa);
		return justificativa;
	}	
}
