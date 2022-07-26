package com.wine_api.wine_api.wines;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;

	@OneToMany(mappedBy = "type", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Wine> wines;

	public Type() {

	}

	public Type(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
