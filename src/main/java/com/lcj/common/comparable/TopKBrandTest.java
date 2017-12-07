package com.lcj.common.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopKBrandTest {
	
	public static void main(String[] args) {  
        List<TopKBrand> list = new ArrayList<TopKBrand>();  
        //TopKBrand参数(商品id 购买数量 流行度)  
        list.add(new TopKBrand(1, 1, 1));  
        list.add(new TopKBrand(1, 3, 1));  
        list.add(new TopKBrand(1, 2, 2));  
        list.add(new TopKBrand(1, 2, 1));  
        list.add(new TopKBrand(1, 3, 3));  
  
        Collections.sort(list);  
  
        for (int i = 0; i < list.size(); i++) {  
            TopKBrand brand = list.get(i);  
            System.out.println(brand.getBrandId() + " "  
                    + brand.getBrandNumber() + " "  
                    + brand.getBrandPopularNumber());  
        }  
    }  

}
