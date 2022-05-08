package br.com.fesa.rotadagasosa.service;

import java.util.List;

import br.com.fesa.rotadagasosa.exception.FlagException;
import br.com.fesa.rotadagasosa.model.Flag;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

public interface FlagService {
	
	public Flag save(BaseAdministratorItemForm form) throws FlagException;
	
	public Flag edit(Flag flag) throws FlagException;
	
	public void delete(Long id) throws FlagException;
	
	public List<Flag> getAll();

}
