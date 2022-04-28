package br.com.fesa.rotadagasosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fesa.rotadagasosa.model.Customer;
import br.com.fesa.rotadagasosa.model.Login;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT NEW br.com.fesa.rotadagasosa.model.Login(c.cpf, c.password, 'CUSTOMER') FROM Customer c WHERE c.cpf = :cpf")
	Login findCustomerCredentials(String cpf);
	
}
