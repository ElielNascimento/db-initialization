package br.com.codeforcadastro.dbinitialization.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.codeforcadastro.dbinitialization.dto.AlunoDTO;
import br.com.codeforcadastro.dbinitialization.service.AlunoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	@ApiOperation(value = "Lista de alunos")
	ResponseEntity<List<AlunoDTO>> findAll() {
		List<AlunoDTO> list = alunoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um aluno pelo ID")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
		AlunoDTO dto = alunoService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	@ApiOperation(value = "Salva um aluno")
	ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto) {
		dto = alunoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("/{id}")
	@ApiOperation( value = "Atuliza um aluno pelo ID")
	ResponseEntity<AlunoDTO> uptade(@PathVariable Long id, @RequestBody AlunoDTO obj) {
		AlunoDTO aluno = alunoService.findById(id);
		return ResponseEntity.ok().body(aluno);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um aluno pelo ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		alunoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
