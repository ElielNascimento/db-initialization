package br.com.codeforcadastro.dbinitialization.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codeforcadastro.dbinitialization.dto.AlunoDTO;
import br.com.codeforcadastro.dbinitialization.entities.Aluno;
import br.com.codeforcadastro.dbinitialization.repository.AlunoRepository;

@Service
public class AlunoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	public AlunoRepository alunoRepository;

	public List<AlunoDTO> findAll() {
		List<Aluno> list = alunoRepository.findAll();
		return list.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
	}

	public AlunoDTO insert(AlunoDTO dto) {
		Aluno aluno = new Aluno(null, dto.getName(), dto.getCpf(), dto.getAddress(), dto.getCurso(), dto.getEscola(),
				dto.getMatriculaList());

		aluno = alunoRepository.save(aluno);
		return new AlunoDTO(aluno);

	}

}