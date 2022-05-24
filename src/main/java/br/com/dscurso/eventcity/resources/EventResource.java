package br.com.dscurso.eventcity.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dscurso.eventcity.entities.dto.EventDTO;
import br.com.dscurso.eventcity.services.EventService;

@RestController
@RequestMapping(value="events")
public class EventResource {
  
	@Autowired
	private EventService service;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO eventDTO){
		eventDTO = service.update(id, eventDTO);
		return ResponseEntity.ok().body(eventDTO);
	} 
}
