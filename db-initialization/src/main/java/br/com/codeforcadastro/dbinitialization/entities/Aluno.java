package br.com.codeforcadastro.dbinitialization.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aluno_id")
	private Long id;

	@Column(name = "aluno_name")
	private String name;

	@Column(name = "aluno_cpf")
	private String cpf;

	@Column(name = "aluno_address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "ID_CURSO")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "ID_ESCOLA")
	private Escola escola;

	@ManyToOne
	@JoinColumn(name = "ID_MATRICULA")
	private Matricula matriculaList;

	public Aluno() {
	}

	public Aluno(Long id, String name, String cpf, String address, Curso curso, Escola escola,
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

	public Long getId() {
		return id;
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
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}

}
