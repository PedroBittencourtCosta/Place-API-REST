package br.com.pedrobittencourt.placeapi.dto;


import br.com.pedrobittencourt.placeapi.domain.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceResponseDto {

    private String name;
    private String slug;
    private String city;
    private String state;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public PlaceResponseDto(Place place){
        BeanUtils.copyProperties(place, this);
    }
}
