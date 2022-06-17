package br.com.codeforcadastro.dbinitialization.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codeforcadastro.dbinitialization.dto.CursoDTO;
import br.com.codeforcadastro.dbinitialization.entities.Aluno;
import br.com.codeforcadastro.dbinitialization.entities.Curso;
import br.com.codeforcadastro.dbinitialization.repository.AlunoRepository;
import br.com.codeforcadastro.dbinitialization.repository.CursoRepository;

@Service
public class CursoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	public CursoRepository cursoRepository;

	@Autowired
	public AlunoRepository alunoRepository;

	public List<CursoDTO> findAll() {
		List<Curso> list = cursoRepository.findAll();
		return list.stream().map(x -> new CursoDTO(x)).collect(Collectors.toList());
	}

	public CursoDTO findById(Long id) {
		Curso curso = cursoRepository.findById(id).get();
		CursoDTO dto = new CursoDTO(curso);
		return dto;
	}

	public CursoDTO insert(CursoDTO dto) {
		Curso curso = new Curso(null, dto.getName(), dto.getDuration(), dto.getAlunoList());
		curso = cursoRepository.save(curso);
		return new CursoDTO(curso);
	}

	public void delete(Long id) {
		cursoRepository.deleteById(id);
	}

	public CursoDTO alunoCurso(Long idAluno, CursoDTO dto) {
		Curso curso = new Curso(dto.getId(), dto.getName(), 
				dto.getDuration(), dto.getAlunoList());

		cursoRepository.save(curso);

		Aluno aluno = alunoRepository.findById(idAluno).get();

		aluno.setAddress(aluno.getName());
		aluno.setAddress(aluno.getAddress());
		aluno.setAge(aluno.getAge());

		curso.getAlunoList().add(aluno);
		aluno.setCurso(curso);

		cursoRepository.save(curso);
		alunoRepository.save(aluno);

		return new CursoDTO(curso);
	}

}
