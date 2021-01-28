package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.dto.CountryDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        return new CountryDto(id, name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Country)) {
            return false;
        }
        Country other = (Country) obj;
        return (Objects.equals(id, other.getId()))
                && (Objects.equals(name, other.getName()));
    }

    @Override
    public String toString() {
        return "País [Id: " + id + ", Nome: " + name + "]";
    }
}
