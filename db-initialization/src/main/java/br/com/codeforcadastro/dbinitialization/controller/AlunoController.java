package br.com.codeforcadastro.dbinitialization.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.codeforcadastro.dbinitialization.dto.AlunoDTO;
import br.com.codeforcadastro.dbinitialization.service.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	ResponseEntity<List<AlunoDTO>> findAll() {
		List<AlunoDTO> list = alunoService.findAll();
		return ResponseEntity.ok().body(list);

	}

	@PostMapping
	ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto) {
		dto = alunoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}