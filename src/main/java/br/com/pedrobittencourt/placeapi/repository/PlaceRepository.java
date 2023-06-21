package br.com.pedrobittencourt.placeapi.repository;

import br.com.pedrobittencourt.placeapi.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlaceRepository extends JpaRepository<Place, UUID> {

    Optional<Place> findByName(String name);
}
