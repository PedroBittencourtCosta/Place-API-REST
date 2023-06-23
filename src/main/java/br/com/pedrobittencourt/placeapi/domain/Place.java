package br.com.pedrobittencourt.placeapi.domain;

import br.com.pedrobittencourt.placeapi.dto.PlaceRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "tb_place")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String slug;
    private String city;
    private String state;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Place(PlaceRequestDto placeRequestDto){
        name = placeRequestDto.name();
        slug = placeRequestDto.slug();
        city = placeRequestDto.city();
        state = placeRequestDto.state();
    }

}
