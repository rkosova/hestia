package com.hestia.app.lang;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @SequenceGenerator(
            name = "lang_sequence",
            sequenceName = "lang_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lang_sequence"
    )

    private Long id;

    private String name;

    private String icon;


    public Language(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public Language(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public Language() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
