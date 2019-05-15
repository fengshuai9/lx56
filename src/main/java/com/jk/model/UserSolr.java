package com.jk.model;


import java.io.Serializable;

public class UserSolr implements Serializable {



    private static final long serialVersionUID = -9083290564183544110L;





    private String id;

    private long product_price;

    private String product_sell_point;

    private String product_title;

    private int product_num;










    public String getProduct_sell_point() {
        return product_sell_point;
    }

    public void setProduct_sell_point(String product_sell_point) {
        this.product_sell_point = product_sell_point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public long getProduct_price() {
        return product_price;
    }

    public void setProduct_price(long product_price) {
        this.product_price = product_price;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", product_price=" + product_price +
                ", product_sell_point='" + product_sell_point + '\'' +
                ", product_title='" + product_title + '\'' +
                ", product_num=" + product_num +
                '}';
    }








}
