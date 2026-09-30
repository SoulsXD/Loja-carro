package br.org.edu.ifrn.LojaCarro;

import br.org.edu.ifrn.LojaCarro.model.Cargo;
import br.org.edu.ifrn.LojaCarro.model.Usuario;
import br.org.edu.ifrn.LojaCarro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LojaCarroApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(LojaCarroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (usuarioRepository.count() == 0) {
			Usuario adminGeral = new Usuario();
			adminGeral.setNome("Administrador Geral");
			adminGeral.setEmail("admin@lojacarro.com");
			adminGeral.setSenha("admin123");
			adminGeral.setCargo(Cargo.ADMINISTRADOR);

			usuarioRepository.save(adminGeral);

			System.out.println("=========================================================");
			System.out.println("Administrador Geral criado com sucesso!");
			System.out.println("E-mail: admin@lojacarro.com");
			System.out.println("Senha: admin123");
			System.out.println("=========================================================");
		}
	}
}