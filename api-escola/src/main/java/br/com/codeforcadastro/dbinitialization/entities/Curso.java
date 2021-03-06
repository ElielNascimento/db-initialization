package br.com.codeforcadastro.dbinitialization.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_curso")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_id")
	private Long id;

	@Column(name = "curso_name")
	private String name;

	@Column(name = "curso_duration")
	private int duration;

	@JsonIgnore
	@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER, 
	cascade = CascadeType.MERGE)
	private List<Aluno> alunoList = new ArrayList<>();

	public Curso() {
	}

	public Curso(Long id, String name, int duration, List<Aluno> alunoList) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.alunoList = alunoList;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuracao(int duration) {
		this.duration = duration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Aluno> getAlunoList() {
		return alunoList;
	}

	public void setAlunoList(List<Aluno> alunoList) {
		this.alunoList = alunoList;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setName(String name) {
		this.name = name;
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
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}

}
