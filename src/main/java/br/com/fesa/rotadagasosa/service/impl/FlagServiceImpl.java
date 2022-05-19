package br.com.fesa.rotadagasosa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.FlagException;
import br.com.fesa.rotadagasosa.message.FlagMessage;
import br.com.fesa.rotadagasosa.model.Flag;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.FlagRepository;
import br.com.fesa.rotadagasosa.service.FlagService;
import br.com.fesa.rotadagasosa.service.validator.FlagValidator;

@Service
public class FlagServiceImpl implements FlagService {

	@Autowired
	private FlagRepository flagRepository;
	
	@Autowired
	private FlagValidator flagValidator;

	@Override
	public Flag save(BaseAdministratorItemForm form) throws FlagException {
		flagValidator.validateForm(form);
		
		Flag retrievedFlagByName = getByName(form.getName());
		
		if(retrievedFlagByName != null) { throw new FlagException(FlagMessage.ERROR_DUPLICATE); }
		
		Flag flag = new Flag();
		flag.setName(form.getName());
		flag.setVisible(form.isVisible());
		
		return flagRepository.save(flag);
	}

	@Override
	public Flag edit(Flag flag) throws FlagException {
		flagValidator.validateFlagFields(flag);
		
		if(flag.getId() == null) { throw new FlagException(FlagMessage.ERROR_ID_NULL); }
		
		Flag flagById = getById(flag.getId());
		
		if(flagById == null) { throw new FlagException(FlagMessage.ERROR_NULL); }
		
		Flag retrievedFlagByName = getByName(flag.getName());
		
		if((retrievedFlagByName != null) && (!flag.getId().equals(flagById.getId()))) { throw new FlagException(FlagMessage.ERROR_DUPLICATE); }
			
		flagById.setName(flag.getName());
		flagById.setVisible(flag.getVisible());
		
		return flagRepository.save(flagById);
	}

	@Override
	public void delete(Long id) throws FlagException {
		if(id == null) { throw new FlagException(FlagMessage.ERROR_ID_NULL); }
	
		flagRepository.deleteById(id);
	}

	@Override
	public List<Flag> getAll() {
		return flagRepository.findAll();
	}
	
	private Flag getByName(String name) {
		return flagRepository.findByName(name);
	}
	
	private Flag getById(Long id) {
		Optional<Flag> flag = flagRepository.findById(id);
		
		if(flag.isPresent() == false) { return null; }
		
		return flag.get();
	}

}