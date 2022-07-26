package com.wine_api.wine_api.wines;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Wine> wines;

    public Type(){

    }

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
