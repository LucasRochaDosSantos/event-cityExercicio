package br.com.dscurso.eventcity.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dscurso.eventcity.entities.City;
import br.com.dscurso.eventcity.entities.Event;
import br.com.dscurso.eventcity.entities.dto.EventDTO;
import br.com.dscurso.eventcity.repository.CityRepository;
import br.com.dscurso.eventcity.repository.EventRepository;
import br.com.dscurso.eventcity.services.exceptions.ResourceEntityNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Autowired
	private CityRepository cityRepository;

	@Transactional(readOnly = true)
	public EventDTO update(Long id, EventDTO eventDTO) {
		try {
			Event event = repository.getReferenceById(id);
			City city = cityRepository.getReferenceById(eventDTO.getCityId());
			event.setName(eventDTO.getName());
			event.setUrl(eventDTO.getUrl());
			event.setDate(eventDTO.getDate());
			event.setCity(city);
			return new EventDTO(event);
		} catch (EntityNotFoundException erro) {
			throw new ResourceEntityNotFoundException(erro.getMessage());
		}
	}
}
