package br.com.fesa.rotadagasosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fesa.rotadagasosa.model.Administrator;
import br.com.fesa.rotadagasosa.model.Login;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

	@Query("SELECT NEW br.com.fesa.rotadagasosa.model.Login(a.email, a.password, 'ADMINISTRATOR') FROM Administrator a WHERE a.email = :username")
	Login findAdministratorCredentials(String username);
	
}
 