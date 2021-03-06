package br.com.livresbs.livres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livresbs.livres.model.Produtor;
import br.com.livresbs.livres.service.ProdutorService;

@RestController
@RequestMapping(value="produtor")
public class ProdutorController {

	@Autowired
	private ProdutorService ps;
	
	@CrossOrigin
	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<Produtor> listarTodosProdutor(){
		return ps.listarProdutores();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public Produtor listarUnicoProdutor(@PathVariable(value = "id") String id) {
		return ps.listarUnicoProdutor(id);
	}
	
	@CrossOrigin
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<String> cadastarProdutor(@RequestBody Produtor produtor){
		return ps.cadastraProdutor(produtor);
	}
	
	@CrossOrigin
	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<String> atualizarProdutores(@RequestBody Produtor produtor){
		return ps.atualizaProduto(produtor);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<String> deletaProdutor(@PathVariable(value="id") String id){
		return ps.deletarProduto(id);
	}
	
	
}
