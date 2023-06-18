package br.com.pedrobittencourt.placeapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PlaceDto(@NotBlank String name, @NotBlank String slug, @NotBlank String city, @NotBlank String state, @NotNull LocalDate createdAt, @NotNull LocalDate updatedAt) {
}
