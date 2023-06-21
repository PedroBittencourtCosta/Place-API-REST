package br.com.pedrobittencourt.placeapi.controller;

import br.com.pedrobittencourt.placeapi.domain.Place;
import br.com.pedrobittencourt.placeapi.dto.PlaceRequestDto;
import br.com.pedrobittencourt.placeapi.dto.PlaceResponseDto;
import br.com.pedrobittencourt.placeapi.service.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/place")
    public ResponseEntity<PlaceResponseDto> savePlace(@RequestBody @Valid PlaceRequestDto placeRequestDtoDto){
        var place = new Place();
        BeanUtils.copyProperties(placeRequestDtoDto, place);
        var placeResponseDto = new PlaceResponseDto(placeService.saveNewPlace(place));
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponseDto);
    }

    @GetMapping("/place/{name}")
    public ResponseEntity<Object> getPlace(@PathVariable(value = "name") String name){
        Optional<Place> optionalPlace =  placeService.getPlaceByName(name);
        if (optionalPlace.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Place not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new PlaceResponseDto(optionalPlace.get()));
    }

}
