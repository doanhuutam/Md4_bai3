package model;

public class Product {
private int id;
private String name;
private int price;
private String mota;

    public Product() {
    }

    public Product(int id, String name, int price, String mota) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
