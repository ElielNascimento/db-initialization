package br.com.codeforcadastro.dbinitialization.dto;

import java.io.Serializable;

import br.com.codeforcadastro.dbinitialization.entities.Aluno;
import br.com.codeforcadastro.dbinitialization.entities.Curso;
import br.com.codeforcadastro.dbinitialization.entities.Escola;
import br.com.codeforcadastro.dbinitialization.entities.Matricula;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String cpf;

	private String address;

	private Curso curso;

	private Escola escola;

	private Matricula matriculaList;

	public AlunoDTO(Long id, String name, String cpf, String address, Curso curso, Escola escola,
			Matricula matriculaList) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.curso = curso;
		this.escola = escola;
		this.matriculaList = matriculaList;
	}

	public AlunoDTO(Aluno entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		address = entity.getAddress();
		curso = entity.getCurso();
		escola = entity.getEscola();
		matriculaList = entity.getMatriculaList();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Matricula getMatriculaList() {
		return matriculaList;
	}

	public void setMatriculaList(Matricula matriculaList) {
		this.matriculaList = matriculaList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

}