package com.fyj.pojo;

public class Movieinfo {
    private Long movieid;

    private String moviecontext;

    private Long price;

    private Long num;

    private String image;

    public Long getMovieid() {
        return movieid;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }

    public String getMoviecontext() {
        return moviecontext;
    }

    public void setMoviecontext(String moviecontext) {
        this.moviecontext = moviecontext == null ? null : moviecontext.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}