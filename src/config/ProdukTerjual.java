package config;

import java.util.ArrayList;

public class ProdukTerjual {
    static public ArrayList <Integer> terjual = new ArrayList<>();
    
    public static void main(String[] args) {
        terjual.add(0);
        terjual.add(1);
        terjual.add(2);
        System.out.println(terjual.get(2));
        terjual.set(2, 200);
        System.out.println(terjual.get(2));
        
    }
    
}
