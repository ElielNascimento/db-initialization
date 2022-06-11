package br.com.codeforcadastro.dbinitialization.dto;

import java.io.Serializable;

import br.com.codeforcadastro.dbinitialization.entities.Aluno;
import br.com.codeforcadastro.dbinitialization.entities.Curso;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String cpf;

	private String address;

	private int age;

	public AlunoDTO(Long id, String name, String cpf, String address, int age) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.address = address;

		this.age = age;

	}

	public AlunoDTO(Aluno entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		address = entity.getAddress();

		age = entity.getAge();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}