package br.com.pedrobittencourt.placeapi.service;

import br.com.pedrobittencourt.placeapi.domain.Place;
import br.com.pedrobittencourt.placeapi.repository.PlaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Transactional
    public Place saveNewPlace(Place place){
        return placeRepository.save(place);
    }
}
