package br.com.codeforcadastro.dbinitialization.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.codeforcadastro.dbinitialization.entities.Aluno;
import br.com.codeforcadastro.dbinitialization.entities.Curso;

public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private int duration;

	private List<Aluno> alunoList = new ArrayList<>();

	public CursoDTO() {
	}

	public CursoDTO(Long id, String name, int duration, List<Aluno> alunoList) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.alunoList = alunoList;
	}

	public CursoDTO(Curso entity) {
		id = entity.getId();
		name = entity.getName();
		duration = entity.getDuration();
		alunoList = entity.getAlunoList();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Aluno> getAlunoList() {
		return alunoList;
	}

	public void setAlunoList(List<Aluno> alunoList) {
		this.alunoList = alunoList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	
	

}
