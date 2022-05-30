package br.com.codeforcadastro.dbinitialization.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_matricula")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matricula ")
	private Long id;

	@Column(name = "matricula_moment")
	private Instant moment;

	@OneToOne(cascade = { CascadeType.DETACH })
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@OneToOne(cascade = { CascadeType.DETACH })
	@JoinColumn(name = "escola_id")
	private Escola escola;

	@OneToOne(cascade = { CascadeType.DETACH })
	@JoinColumn(name = "curso_id")
	private Curso curso;

	public Matricula(Long id, Instant moment, Aluno aluno, Escola escola, Curso curso) {
		super();
		this.id = id;
		this.moment = moment;
		this.aluno = aluno;
		this.escola = escola;
		this.curso = curso;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
		Matricula other = (Matricula) obj;
		return Objects.equals(id, other.id);
	}

}
