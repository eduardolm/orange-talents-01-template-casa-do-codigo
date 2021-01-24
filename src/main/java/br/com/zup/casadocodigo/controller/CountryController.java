package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.controller.request.CountryRequestDto;
import br.com.zup.casadocodigo.dto.CountryDetailDto;
import br.com.zup.casadocodigo.dto.CountryDto;
import br.com.zup.casadocodigo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    public ResponseEntity<CountryDto> create(@RequestBody @Valid CountryRequestDto countryRequestDto) {
        return ResponseEntity.ok(countryRepository.save(countryRequestDto.toCountry()).toCountryDto());
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> findAll() {
        return ResponseEntity.ok(CountryDto.toCountryDto(countryRepository.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDetailDto> findById(@PathVariable() Long id) {
        CountryDetailDto response = new CountryDetailDto(countryRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("País não encontrado.")));
        return ResponseEntity.ok(response);
    }
}
