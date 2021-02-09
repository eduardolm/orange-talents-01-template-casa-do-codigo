package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.controller.request.CountryRequestDto;
import br.com.zup.casadocodigo.dto.CountryDto;
import br.com.zup.casadocodigo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    public ResponseEntity<CountryDto> create(@RequestBody @Valid CountryRequestDto countryRequestDto) {
        return ResponseEntity.ok(countryRepository.save(countryRequestDto.toCountry()).toCountryDto());
    }
}
