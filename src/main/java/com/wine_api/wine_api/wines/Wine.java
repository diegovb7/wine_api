package com.wine_api.wine_api.wines;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import com.wine_api.wine_api.validation.MaxCurrentYear;

import java.io.Serializable;

@Entity
@Table(name = "wine")
public class Wine implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Min(1900)
    @MaxCurrentYear()
    private String year;

    @NotNull
    @Range(min = 0, max = 5)
    private Float rating;

    @NotNull
    @Positive
    private Integer num_reviews;

    @NotNull
    @Positive
    private Float price;

    @NotNull
    @Range(min = 1, max = 5)
    private String body;

    @NotNull
    @Range(min = 1, max = 5)
    private String acidity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "winery_id", nullable = false)
    @NotNull
    private Winery winery;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    @NotNull
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    @NotNull
    private Region region;

    public Wine(){

    }

    public Wine(Integer id, String name, String year, Float rating, Integer num_reviews, Float price, String body,
            String acidity, Winery winery, Type type, Region region) {
        super();
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
        this.winery = winery;
        this.type = type;
        this.region = region;
    }

    

    public Wine(String name, String year, Float rating, Integer num_reviews, Float price, String body,
            String acidity, Winery winery, Type type, Region region) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
        this.winery = winery;
        this.type = type;
        this.region = region;
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



    public String getYear() {
        return year;
    }



    public void setYear(String year) {
        this.year = year;
    }



    public Float getRating() {
        return rating;
    }



    public void setRating(Float rating) {
        this.rating = rating;
    }



    public Integer getNum_reviews() {
        return num_reviews;
    }



    public void setNum_reviews(Integer num_reviews) {
        this.num_reviews = num_reviews;
    }



    public Float getPrice() {
        return price;
    }



    public void setPrice(Float price) {
        this.price = price;
    }



    public String getBody() {
        return body;
    }



    public void setBody(String body) {
        this.body = body;
    }



    public String getAcidity() {
        return acidity;
    }



    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }



    public Winery getWinery() {
        return winery;
    }



    public void setWinery(Winery winery) {
        this.winery = winery;
    }



    public Type getType() {
        return type;
    }



    public void setType(Type type) {
        this.type = type;
    }



    public Region getRegion() {
        return region;
    }



    public void setRegion(Region region) {
        this.region = region;
    }

    



	@Override
	public String toString() {
		return "Wine [id=" + id + ", name=" + name + ", year=" + year + ", rating=" + rating + ", num_reviews="
				+ num_reviews + ", price=" + price + ", body=" + body + ", acidity=" + acidity + ", winery=" + winery
				+ ", type=" + type + ", region=" + region + "]";
	}




    
}
