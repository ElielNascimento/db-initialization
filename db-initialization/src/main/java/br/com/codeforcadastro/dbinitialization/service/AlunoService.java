package br.com.codeforcadastro.dbinitialization.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codeforcadastro.dbinitialization.dto.AlunoDTO;
import br.com.codeforcadastro.dbinitialization.entities.Aluno;
import br.com.codeforcadastro.dbinitialization.repository.AlunoRepository;
import br.com.codeforcadastro.dbinitialization.repository.CursoRepository;

@Service
public class AlunoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	public AlunoRepository alunoRepository;

	@Autowired
	public CursoRepository cursoRepository;

	public List<AlunoDTO> findAll() {
		List<Aluno> list = alunoRepository.findAll();
		return list.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
	}

	public AlunoDTO findById(Long id) {
		Aluno aluno = alunoRepository.findById(id).get();
		AlunoDTO dto = new AlunoDTO(aluno);
		return dto;
	}

	public AlunoDTO insert(AlunoDTO dto) {
		Aluno aluno = new Aluno(null, dto.getName(), dto.getCpf(), dto.getAddress(), dto.getAge());
		if (aluno.getAge() < 18) {
			throw new RuntimeException("Inscrição apenas > de 18 anos");
		}

		else {
			aluno = alunoRepository.save(aluno);
			return new AlunoDTO(aluno);
		}

	}

	public AlunoDTO uptade(Long id, AlunoDTO obj) {
		Aluno aluno = alunoRepository.findById(id).get();

		aluno.setName(obj.getName());
		aluno.setAddress(obj.getAddress());
		aluno.setCpf(obj.getCpf());
		aluno.setAge(obj.getAge());

		alunoRepository.save(aluno);

		return new AlunoDTO(aluno);
	}

	public void delete(Long id) {
		alunoRepository.deleteById(id);
	}

}
