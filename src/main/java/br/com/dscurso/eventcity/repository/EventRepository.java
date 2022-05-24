package br.com.dscurso.eventcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dscurso.eventcity.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
