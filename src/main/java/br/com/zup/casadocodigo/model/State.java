package br.com.zup.casadocodigo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estados")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Country country;

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public State() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((country.getId() == null) ? 0 : country.getId().hashCode());
        result = prime * result + ((country.getName() == null) ? 0 : country.getName().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof State)) {
            return false;
        }
        State other = (State) obj;
        return (Objects.equals(id, other.id))
                && (Objects.equals(name, other.name))
                && (Objects.equals(country.getId(), other.country.getId()))
                && (Objects.equals(country.getName(), other.country.getName()));
    }

    @Override
    public String toString() {
        return "Estado [Nome: " + name + ", idPaís: " + country.getId() + "]";
    }
}
