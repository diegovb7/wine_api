package com.wine_api.wine_api.wines;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wine")
public class Wine implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer year;
    private Float rating;
    private Integer num_reviews;
    private Float price;
    private Integer body;
    private Integer acidity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "winery_id", nullable = false)
    private Winery winery;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    public Wine(){

    }

    public Wine(String name, Integer year, Float rating, Integer num_reviews, Float price, Integer body,
            Integer acidity, Winery winery) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
        this.winery = winery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
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

    public Integer getBody() {
        return body;
    }

    public void setBody(Integer body) {
        this.body = body;
    }

    public Integer getAcidity() {
        return acidity;
    }

    public void setAcidity(Integer acidity) {
        this.acidity = acidity;
    }

    public Winery getWinery() {
        return winery;
    }

    public void setWinery(Winery winery) {
        this.winery = winery;
    }

    

    
}
