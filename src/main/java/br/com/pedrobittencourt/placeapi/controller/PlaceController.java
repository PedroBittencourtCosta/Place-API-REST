package br.com.pedrobittencourt.placeapi.controller;

import br.com.pedrobittencourt.placeapi.domain.Place;
import br.com.pedrobittencourt.placeapi.dto.PlaceDto;
import br.com.pedrobittencourt.placeapi.service.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/place")
    public ResponseEntity<PlaceDto> savePlace(@RequestBody @Valid PlaceDto placeDto){
        var place = new Place();
        BeanUtils.copyProperties(placeDto, place);
        placeService.saveNewPlace(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeDto);
    }

}