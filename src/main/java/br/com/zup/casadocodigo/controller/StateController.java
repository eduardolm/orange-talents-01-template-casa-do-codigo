package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.controller.request.StateRequestDto;
import br.com.zup.casadocodigo.dto.StateDto;
import br.com.zup.casadocodigo.exception.StateConversionException;
import br.com.zup.casadocodigo.repository.CountryRepository;
import br.com.zup.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    public ResponseEntity<StateDto> create(@RequestBody @Valid StateRequestDto stateRequestDto) throws StateConversionException {
        if (!stateRepository.existsStateByName(stateRequestDto.convertStateRequestToState(countryRepository).getName())) {

            return ResponseEntity.ok().body(new StateDto(stateRepository
                    .save(stateRequestDto.convertStateRequestToState(countryRepository))));
        }
        return ResponseEntity.badRequest().build();
    }
}
