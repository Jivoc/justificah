package progweb.prova01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import progweb.prova01.model.Juiz;
import progweb.prova01.model.Justificativa;
import progweb.prova01.model.Situacao;
import progweb.prova01.repository.JuizRepository;
import progweb.prova01.repository.JustificativaRepository;
import progweb.prova01.service.JustificativaService;

@Controller
@RequestMapping("/analisar")
public class AnalisarController {

	
	@Autowired
	private JustificativaRepository justificavaRepository;
	
	@Autowired
	private JuizRepository juizRepository;
	
	@Autowired
	private JustificativaService justificativaService;
	
	@GetMapping("/abertas")
	public ModelAndView direcionaCrud() {
		ModelAndView mv = new ModelAndView("/analisar/abertas");
		List<Justificativa> justifica = justificavaRepository.buscarComCidadaoEleicao(Situacao.ABERTO);
		mv.addObject("justificativas", justifica);
		List<Juiz> juizes = juizRepository.findBySituacaoNot(Situacao.INATIVO);
		mv.addObject("juizes", juizes);
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Justificativa justificativaAux, String stringJustificar) {
		ModelAndView mv = new ModelAndView("mostrarmensagem");
		if(stringJustificar.equals("Aceita")) {
			justificativaAux.setSituacao(Situacao.ACEITA);
			mv.addObject("urlretorno", "/analisar/abertas");
		}
		else {
			justificativaAux.setSituacao(Situacao.NEGADA);
			mv.addObject("urlretorno", "/analisar/abertas");
		}
		mv.addObject("mensagem", "Justificativa analisada com sucesso.");
		justificativaService.alterar(justificativaAux);
		return mv;
	}
}
