package com.wine_api.wine_api.wines;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "winery")
public class Winery implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "winery", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Wine> wines;

    public Winery(){

    }
    
    

    public Winery(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public Winery(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



	@Override
	public String toString() {
		return "Winery [id=" + id + ", name=" + name +  "]";
	}

    

}
