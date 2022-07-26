package com.wine_api.wine_api.wines;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Wine> wines;

    public Type(){

    }

    public Type(String name, Set<Wine> wines) {
        this.name = name;
        this.wines = wines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Wine> getWines() {
        return wines;
    }

    public void setWines(Set<Wine> wines) {
        this.wines = wines;
    }

}
