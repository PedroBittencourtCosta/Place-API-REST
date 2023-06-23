package br.com.pedrobittencourt.placeapi.service;

import br.com.pedrobittencourt.placeapi.domain.Place;
import br.com.pedrobittencourt.placeapi.dto.PlaceRequestDto;
import br.com.pedrobittencourt.placeapi.dto.PlaceResponseDto;
import br.com.pedrobittencourt.placeapi.repository.PlaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Transactional
    public PlaceResponseDto saveNewPlace(PlaceRequestDto placeRequestDto){
        Place place = new Place();
        BeanUtils.copyProperties(placeRequestDto, place);
        place.setCreatedAt(LocalDate.now());
        place.setUpdatedAt(LocalDate.now());
        return new PlaceResponseDto(placeRepository.save(place));
    }

    @Transactional
    public Optional<PlaceResponseDto> getPlaceById(UUID id){
        Optional<Place> optionalPlace =  placeRepository.findById(id);
        return Optional.of(new PlaceResponseDto(optionalPlace.get()));
    }

    @Transactional
    public List<PlaceResponseDto> getPlaceList(){
        List<Place> placeList = placeRepository.findAll();
        return placeList.stream().map(place -> new PlaceResponseDto(place)).toList();
    }


}
