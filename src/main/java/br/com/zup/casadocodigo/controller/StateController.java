package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.controller.request.StateRequestDto;
import br.com.zup.casadocodigo.dto.StateDetailDto;
import br.com.zup.casadocodigo.dto.StateDto;
import br.com.zup.casadocodigo.exception.StateConversionException;
import br.com.zup.casadocodigo.model.State;
import br.com.zup.casadocodigo.repository.CountryRepository;
import br.com.zup.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<StateDto>> findAll() {
        List<State> states = stateRepository.findAll();
        return ResponseEntity.ok(states.stream().map(StateDto::new).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<StateDetailDto> findById(@PathVariable() Long id) {
        StateDetailDto response = new StateDetailDto(stateRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Estado não encontrado.")));
        return ResponseEntity.ok(response);
    }
}
