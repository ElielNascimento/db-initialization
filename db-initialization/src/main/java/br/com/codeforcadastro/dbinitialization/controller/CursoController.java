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

import br.com.codeforcadastro.dbinitialization.dto.CursoDTO;
import br.com.codeforcadastro.dbinitialization.service.CursoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cursos")
public class CursoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	public CursoService cursoService;

	@GetMapping
	@ApiOperation(value = "Lista de cursos")
	private ResponseEntity<List<CursoDTO>> findAll() {
		List<CursoDTO> list = cursoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	@ApiOperation(value = "Salva um curso")
	private ResponseEntity<CursoDTO> insert(@RequestBody CursoDTO dto) {
		dto = cursoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um curso pelo ID")
	private ResponseEntity<CursoDTO> findyById(@PathVariable Long id) {
		CursoDTO obj = cursoService.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um curso pelo ID")
	private ResponseEntity<CursoDTO> update(@PathVariable Long id, @RequestBody CursoDTO obj) {
		CursoDTO dto = cursoService.update(id, obj);
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta Curso pelo ID")
	private void DeleteById(@PathVariable Long id) {
		cursoService.delete(id);
		ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}")
	@ApiOperation(value = "Adiciona um aluno ao curso pelo ID")
	public ResponseEntity<CursoDTO> alunoCurso(@PathVariable Long id, @RequestBody CursoDTO dto) {
		CursoDTO curso = cursoService.alunoCurso(id, dto);
		return ResponseEntity.ok().body(curso);

	}

}
