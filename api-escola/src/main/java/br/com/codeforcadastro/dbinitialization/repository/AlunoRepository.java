package br.com.codeforcadastro.dbinitialization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codeforcadastro.dbinitialization.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
