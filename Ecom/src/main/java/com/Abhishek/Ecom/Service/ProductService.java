package com.Abhishek.Ecom.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Abhishek.Ecom.model.Product;
import com.Abhishek.Ecom.repo.productRepo;


@Service
public class ProductService {
	@Autowired
	productRepo repo;
	
	public void saveProduct(List<Product> product)
	{
		
		repo.saveAll(product);
	}

	public List<Product> getProducts() {
		
		return repo.findAll();
	}
	
	public Product getProductbyId(int productId) {
		return repo.findById(productId).orElse(new Product());
	}

	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		product.setImgname(imageFile.getOriginalFilename());
		product.setImgType(imageFile.getContentType());
		product.setimageFile(imageFile.getBytes());
		return repo.save(product);
	}


	public Product updateproduct(int productId, Product product, MultipartFile imageFile) throws IOException 
	{
		
		product.setImgname(imageFile.getOriginalFilename());
		product.setImgType(imageFile.getContentType());
		product.setimageFile(imageFile.getBytes());
		return repo.save(product);
	}

	public void deleteproduct(int id) {
	        repo.deleteById(id);
		
	}

	public List<Product> searchproduct(String keyword)
	{
		List<Product> products =  repo.searchproducts(keyword);
		return products;
	}

	

	
	

	
	

}
