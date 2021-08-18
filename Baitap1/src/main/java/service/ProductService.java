package service;

import model.Product;

import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> list =new ArrayList<>();
    public ProductService(){
        list.add(new Product(1,"doanhuutam",2002,"hàng auth"));
        list.add(new Product(1,"toanbale",98,"hàng auth"));
    }
    public void save(Product product){
        list.add(product);
    }
    public void delete(int index){
        list.remove(index);
    }
    public void edit(Product product,int index){
        list.set(index,product);
    }
    public static ArrayList<Product> findByname(String name){
        ArrayList<Product> list1=new ArrayList<>();
        for (int i=0;i<list1.size();i++){
            if (list1.get(i).getName().contains(name)){
                list1.add(list1.get(i));
            }
        }
        return list1;

    }
}
