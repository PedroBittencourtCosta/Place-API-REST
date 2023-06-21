package br.com.pedrobittencourt.placeapi.dto;

import jakarta.validation.constraints.NotBlank;

public record PlaceRequestDto(@NotBlank String name, @NotBlank String slug, @NotBlank String city, @NotBlank String state) {
}
