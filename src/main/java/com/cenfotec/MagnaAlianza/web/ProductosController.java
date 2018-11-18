package com.cenfotec.MagnaAlianza.web;

import java.text.ParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cenfotec.MagnaAlianza.domain.Cafe;
import com.cenfotec.MagnaAlianza.domain.Finca;
import com.cenfotec.MagnaAlianza.repository.CafeRepository;
import com.cenfotec.MagnaAlianza.repository.FincaRepository;

@Controller
public class ProductosController {

	@Autowired
	FincaRepository fincarepo;
	
	@Autowired
	CafeRepository repo;
	
	@RequestMapping("/productos/ver/{id}")
	 public String formularioFinca(@PathVariable("id")long id, Model model) throws ParseException{
		 model.addAttribute("productos", repo.findByNumeroFinca(id));
		 model.addAttribute("idFinca", id);
		 return "productos";
	 }
	
	@RequestMapping("/productos/crear/{id}")
	 public String formularioProductor(@PathVariable("id")long id, Model model) throws ParseException{
		 model.addAttribute("cafe", new Cafe((long) id, "" , (long) 0));
		 return "formCafe";
	 }
	
	 @PostMapping("/productos/crear")
	 public String fincaSubmit(@ModelAttribute Cafe cafe, Model model) {
		 Finca finca = fincarepo.findById(cafe.getNumeroFinca()).get();
		 cafe.setCedulaPropietario(finca.getCedulaPropietario());
		 model.addAttribute("idFinca", cafe.getNumeroFinca());
		 repo.save(cafe);
		 
		 model.addAttribute("productos",repo.findByNumeroFinca(cafe.getNumeroFinca()));
		  return "productos";
	 }
}
