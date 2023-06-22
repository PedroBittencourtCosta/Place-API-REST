package br.com.pedrobittencourt.placeapi.service;

import br.com.pedrobittencourt.placeapi.domain.Place;
import br.com.pedrobittencourt.placeapi.repository.PlaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Transactional
    public Place saveNewPlace(Place place){
        place.setCreatedAt(LocalDate.now());
        place.setUpdatedAt(LocalDate.now());
        return placeRepository.save(place);
    }

    @Transactional
    public Optional<Place> getPlaceByName(String name){
        return placeRepository.findByName(name);
    }

    @Transactional
    public List<Place> getPlaceList(){
        return placeRepository.findAll();
    }


}
