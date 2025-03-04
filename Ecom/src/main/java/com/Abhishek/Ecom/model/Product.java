package com.Abhishek.Ecom.model;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class Product
{  
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String descripton;
	private String brand;
	private BigDecimal price;
	private String category;
	
	
	private Date releaseDate;
	private boolean productAvailable;
	private int  stockQuantity;
	
	private String imgname;
	private String imgType;
	
	@Lob
	private byte [] imageFile;
	
	
	
	public Product(int id, String name, String descripton, String brand, BigDecimal price, String category,
			Date releaseDate, boolean productAvailable, int stockQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.descripton = descripton;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.releaseDate = releaseDate;
		this.productAvailable = productAvailable;
		this.stockQuantity = stockQuantity;
		
	
	}
	public Product()
	{
		
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
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isproductAvailable() {
		return productAvailable;
	}
	public void setproductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}
	public int getstockQuantity() {
		return stockQuantity;
	}
	public void setstockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public void setimageFile(byte[] imageFile) {
		this.imageFile = imageFile;
	}
	public byte[] getimageFile() {
		return imageFile;
	}
	
	
	
	
}