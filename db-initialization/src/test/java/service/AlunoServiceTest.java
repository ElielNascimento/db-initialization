package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.codeforcadastro.dbinitialization.service.AlunoService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class AlunoServiceTest {

	@Autowired
	private AlunoService aluno;

	@Test
	public void findByIdTest() {
		aluno.findById(11L) ;
	}

}
