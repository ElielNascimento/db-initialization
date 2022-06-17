package br.com.codeforcadastro.dbinitialization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codeforcadastro.dbinitialization.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
