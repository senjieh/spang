package com.spang.prod.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Word {
    @Id
    private Integer id;
    private String name;
    private List <String> def;

    public Word() {}

    public Word(Integer id, String name, List <String> def) {
        this.id = id;
        this.name = name;
        this.def = def;
    }

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getWord() { return name; }
    public void setWord(String name) { this.name = name; }

    public List <String> getDef() { return def; }
    public void setDef( List <String> def) { this.def = def; }
}
