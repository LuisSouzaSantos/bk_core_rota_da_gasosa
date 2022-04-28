package br.com.fesa.rotadagasosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fesa.rotadagasosa.model.GasStation;
import br.com.fesa.rotadagasosa.model.Login;

public interface GasStationRepository extends JpaRepository<GasStation, Long> {

	@Query("SELECT NEW br.com.fesa.rotadagasosa.model.Login(gs.cnpj, gs.password, 'GAS_STATION') FROM GasStation gs WHERE gs.cnpj = :cnpj")
	Login findGasStationCredentials(String cnpj);
	
}
