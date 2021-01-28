package br.com.zup.casadocodigo.utils.builder;

import br.com.zup.casadocodigo.model.Author;

public class AuthorBuilder {

    private String name;
    private String email;
    private String description;

    public AuthorBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AuthorBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public AuthorBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Author build() {
        return new Author(name, email, description);
    }
}
