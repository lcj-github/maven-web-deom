package com.lcj.common.comparable;

//实现比较接口，降序排列 
public class TopKBrand implements Comparable<Object> {

	private int brandId; //商品id  
    private int brandNumber; //商品购买数目  
    private int brandPopularNumber; //商品流行度 
    
    @Override  
    public int compareTo(Object o) {  
        TopKBrand brand = (TopKBrand) o;  
        if (brand.getBrandNumber() != this.brandNumber)  
            return brand.getBrandNumber() - this.brandNumber;  
  
        if (brand.getBrandPopularNumber() != this.brandPopularNumber)  
            return brand.getBrandPopularNumber() - this.brandPopularNumber;  
  
        return 0;  
    } 
  
    public TopKBrand(int brandId, int brandNumber, int brandPopularNumber) {  
        super();  
        this.brandId = brandId;  
        this.brandNumber = brandNumber;  
        this.brandPopularNumber = brandPopularNumber;  
    }  
  
    public int getBrandId() {  
        return brandId;  
    }  
  
    public int getBrandNumber() {  
        return brandNumber;  
    }  
  
    public int getBrandPopularNumber() {  
        return brandPopularNumber;  
    }  
  
   
}
