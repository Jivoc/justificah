package progweb.prova01.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import progweb.prova01.model.Cidadao;
import progweb.prova01.model.Eleicao;
import progweb.prova01.model.Justificativa;
import progweb.prova01.model.Situacao;
import progweb.prova01.repository.CidadaoRepository;
import progweb.prova01.repository.EleicaoRepository;
import progweb.prova01.service.JustificativaService;

@Controller
@RequestMapping("/justificar")
public class JustificativaController {

	
	
	@Autowired
	private CidadaoRepository cidadaoRepository;
	
	@Autowired 
	private EleicaoRepository eleicaoRepository;
	
	@Autowired
	private JustificativaService justificativaService;
	
	@GetMapping("/crud")
	public ModelAndView direcionaCrud() {
		ModelAndView mv = new ModelAndView("/justificativa/crud");
		List<Cidadao> cidadaos = cidadaoRepository.findBySituacaoNot(Situacao.INATIVO);
		mv.addObject("cidadaos", cidadaos);
		mv.addObject("mensagemcidadaos", "Não foram encontrados cidadaos ativos!");
		List<Eleicao> eleicoes = eleicaoRepository.findBySituacaoNot(Situacao.INATIVO);
		mv.addObject("eleicoes", eleicoes);
		mv.addObject("mensagemeleicoes", "Não foram encontradas eleições ativas!");
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView novo(Justificativa justificativaVerify) {
		ModelAndView mv = new ModelAndView("mostrarmensagem");
		mv.addObject("urlretorno", "/index.html");		
		Justificativa justificativaState = justificativaService.salvar(justificativaVerify);		
		if (justificativaState.getCodigo() == null) {
			mv.addObject("mensagem", "Error ao cadastrar a justificativa.");
		} else {	
			mv.addObject("mensagem", "Justificativa cadastrada com sucesso.");
		}
		return mv;
	}
	
}
