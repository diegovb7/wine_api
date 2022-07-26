package com.wine_api.wine_api.wines;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "region")
public class Region implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "region", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Wine> wines;

    public Region(){

    }

    public Region(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
