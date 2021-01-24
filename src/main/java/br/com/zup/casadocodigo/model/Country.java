package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.dto.CountryDto;

import javax.persistence.*;

@Entity
@Table(name = "paises")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Country(String name) {
        this.name = name;
    }

    public Country() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryDto toCountryDto() {
        return new CountryDto(name);
    }
}
