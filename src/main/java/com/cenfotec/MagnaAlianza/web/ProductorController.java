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
import org.springframework.web.bind.annotation.RequestMethod;

import com.cenfotec.MagnaAlianza.domain.Finca;
import com.cenfotec.MagnaAlianza.domain.Productor;
import com.cenfotec.MagnaAlianza.repository.FincaRepository;
import com.cenfotec.MagnaAlianza.repository.ProductorRepository;

@Controller
public class ProductorController {

	@Autowired
	ProductorRepository repo;
	
	@Autowired
	FincaRepository fincarepo;
	
	@RequestMapping("/")
	public String index(Model model) throws ParseException{	
		model.addAttribute("productor", new Productor((long) 1,"","", "", ""));
		return "index";
	}
	
	@PostMapping("/productor/buscar")
		public String buscarProductor(@ModelAttribute Productor productor, Model model) throws ParseException{
			model.addAttribute("productores", repo.findByNombreContaining(productor.getNombre()));
		 	return "buscquedaProductores";
	}
	
	@RequestMapping("/productor/crearProductor")
	 public String formularioProductor(Model model) throws ParseException{
		 model.addAttribute("productor", new Productor((long) 1,"Digite su nombre","Digite la direccion", "Digite la direccion politica", "Digite la Empresa"));
		 return "formProductor";
	 }
	
	 @PostMapping("/productor/crearProductor")
	 public String productorSubmit(@ModelAttribute Productor productor) {
		 repo.save(productor);
		 return "result";
	 }
	 
	 @RequestMapping(value = "/productor/todos", method = RequestMethod.GET)
		public String allProductores(Model model) throws ParseException{
		 	model.addAttribute("productores", repo.findAll());
		 	return "listaProductores";
	}
	 
	 @RequestMapping(value = "/productor/ver/{id}", method = RequestMethod.GET)
		public String verProductor(@PathVariable("id")long id, Model model) throws ParseException{
		 	model.addAttribute("productores",repo.findById(id).get());
		 	List<Finca> fincas = fincarepo.findAll();
		 	List<Finca> result = fincas.stream().filter(f -> f.getCedulaPropietario().equals(id)).collect(Collectors.toList());
		 	model.addAttribute("fincas", result);
		 	return "productor";
	}
}
