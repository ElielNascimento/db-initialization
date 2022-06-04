package br.com.codeforcadastro.dbinitialization.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@OneToMany
	@JoinColumn(name = "ID_MATRICULA")
	private List<Aluno> alunoList;

	public Matricula() {
	}

	public Matricula(Long id, Instant moment, List<Aluno> alunoList) {
		super();
		this.id = id;
		this.moment = moment;
		this.alunoList = alunoList;
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

	public List<Aluno> getAlunoList() {
		return alunoList;
	}

	public void setAlunoList(List<Aluno> alunoList) {
		this.alunoList = alunoList;
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
