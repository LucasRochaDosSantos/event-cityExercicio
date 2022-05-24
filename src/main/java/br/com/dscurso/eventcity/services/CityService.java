package br.com.dscurso.eventcity.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dscurso.eventcity.entities.City;
import br.com.dscurso.eventcity.entities.dto.CityDTO;
import br.com.dscurso.eventcity.repository.CityRepository;
import br.com.dscurso.eventcity.services.exceptions.DataBaseException;
import br.com.dscurso.eventcity.services.exceptions.ResourceEntityNotFoundException;

@Service
public class CityService {
    
	@Autowired
	private CityRepository repository;
	
	@Transactional(readOnly = true)
	public List<CityDTO> findAll(){
		List<City> listaCity = repository.findAll(Sort.by("name"));
		return listaCity.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public CityDTO insert(CityDTO cityDTO){
		City city = new City();
	    city.setName(cityDTO.getName());
	    city = repository.save(city);
	    return new CityDTO(city);
	}
	
	public void delete(Long id) {
		try {
		    repository.deleteById(id);
		}catch(EmptyResultDataAccessException erro){
			throw new ResourceEntityNotFoundException(erro.getMessage());
		}catch(DataIntegrityViolationException erro) {
			throw new DataBaseException(erro.getMessage());
			
		}
	}
}
