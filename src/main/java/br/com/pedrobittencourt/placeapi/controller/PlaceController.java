package br.com.pedrobittencourt.placeapi.controller;

import br.com.pedrobittencourt.placeapi.dto.PlaceRequestDto;
import br.com.pedrobittencourt.placeapi.dto.PlaceResponseDto;
import br.com.pedrobittencourt.placeapi.service.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/place")
    public ResponseEntity<PlaceResponseDto> savePlace(@RequestBody @Valid PlaceRequestDto placeRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(placeService.saveNewPlace(placeRequestDto));
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<PlaceResponseDto> getPlace(@PathVariable(value = "id")UUID id){
        Optional<PlaceResponseDto> optionalPlaceResponseDto = placeService.getPlaceById(id);
        if (optionalPlaceResponseDto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalPlaceResponseDto.get());
    }

    @GetMapping("/place")
    public ResponseEntity<List<PlaceResponseDto>> getListPlace(){
        return ResponseEntity.status(HttpStatus.OK).body(placeService.getPlaceList());
    }

    @PutMapping("/place/{id}")
    public ResponseEntity<PlaceResponseDto> changePlace(@PathVariable(value = "id") UUID id,
                                                        @RequestBody @Valid PlaceRequestDto placeRequestDto){

        Optional<PlaceResponseDto> optionalPlaceResponseDto = Optional.of(placeService.changePlace(id, placeRequestDto));
        if (optionalPlaceResponseDto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalPlaceResponseDto.get());

    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity<Object> deletePlace(@PathVariable(value = "id") UUID id){
        var result = placeService.deletePlace(id);
        if (result != null){
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
