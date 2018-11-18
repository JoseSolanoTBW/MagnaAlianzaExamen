package com.cenfotec.MagnaAlianza.web;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cenfotec.MagnaAlianza.domain.Finca;
import com.cenfotec.MagnaAlianza.repository.FincaRepository;
import com.cenfotec.MagnaAlianza.repository.ProductorRepository;

@Controller
public class FincaController {

	@Autowired
	FincaRepository fincarepo;
	
	@Autowired
	ProductorRepository repo;
	
	@RequestMapping("/finca/crearFinca/{id}")
	 public String formularioFinca(@PathVariable("id")long id, Model model) throws ParseException{
		 model.addAttribute("finca", new Finca( (long) 0, (long) 0,(long) id));
		 return "fromFinca";
	 }
	
	 @PostMapping("/finca/crearFinca")
	 public String fincaSubmit(@ModelAttribute Finca finca, Model model) {
		 fincarepo.save(finca);
		 model.addAttribute("productores",repo.findById(finca.getCedulaPropietario()).get());
		 List<Finca> fincas = fincarepo.findAll();
		 List<Finca> result = fincas.stream().filter(f -> f.getCedulaPropietario().equals(finca.getCedulaPropietario())).collect(Collectors.toList());
		 model.addAttribute("fincas", result);
		 return "productor";
	 }
}
