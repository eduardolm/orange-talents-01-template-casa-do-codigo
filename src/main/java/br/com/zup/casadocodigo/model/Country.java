package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.dto.CountryDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paises")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    private List<State> states = new ArrayList<>();

    public Country(String name, List<State> states) {
        this.name = name;
        this.states = states;
    }

    public Country(String name) {
        this.name = name;
    }

    public Country() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<State> getStates() {
        return states;
    }

    public CountryDto toCountryDto() {
        return new CountryDto(name);
    }
}
