package com.example.raj.testst;

/**
 * Created by raj on 2/1/16.
 */
public class Stationary {
    private String imgUrl;
    private String name;
    private String desc;
    private Long price;
    private Long qty;
    public Stationary(){

    }
    public Stationary(String name,Long qty,Long price,String desc){
        this.name=name;
        this.desc=desc;
        this.qty=qty;
        this.price=price;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
}
