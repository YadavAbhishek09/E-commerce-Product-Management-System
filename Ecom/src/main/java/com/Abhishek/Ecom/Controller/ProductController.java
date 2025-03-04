package com.Abhishek.Ecom.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.DeleteExchange;

import com.Abhishek.Ecom.Service.ProductService;
import com.Abhishek.Ecom.model.Product;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class ProductController {
	@Autowired
	private ProductService service;
	
	

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.getProducts();
	}

	List<Product> product = new ArrayList<Product>(Arrays.asList(
			new Product(101, "mobile", "this is a realme mobile with good processor and high quality camera", "Realme",
					BigDecimal.valueOf(12000), "Android", Date.valueOf("2024-01-01"), true, 100),
			new Product(102, "laptop", "Good processor with dedicated graphic card", "MSI", BigDecimal.valueOf(50000),
					"Laptop", Date.valueOf("2023-02-01"), true, 10),
			new Product(103, "mobile", "this is a  high quality camera phone", "MI", BigDecimal.valueOf(18000),
					"Android", Date.valueOf("2024-05-05"), true, 10),
			new Product(104, "laptop", "Good processor with dedicated graphic card", "MSI", BigDecimal.valueOf(50000),
					"Laptop", Date.valueOf("2023-02-01"), true, 10)));

	@PostMapping("/save")
	public void saveProduct() {
		service.saveProduct(product);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> getproductbyId(@PathVariable int productId) {
		Product product = service.getProductbyId(productId);

		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart   MultipartFile imageFile)
	{
		
		try {
			Product product1= service.addProduct(product,imageFile);
			return new ResponseEntity<>(product1,HttpStatus.CREATED);
			
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@GetMapping("/product/{productId}/image")
	public ResponseEntity<byte []> getProductbyId(@PathVariable int productId)
	
	{
		Product product = service.getProductbyId(productId);
		byte [] imageFile = product.getimageFile();
		
		return ResponseEntity.ok().body(imageFile);
	}
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable int productId ,@RequestPart  Product product, @RequestPart MultipartFile imageFile) throws IOException
	
	{
		Product product1 = service.getProductbyId(productId);
		
		
		if(product1 != null)
		{
			service.updateproduct(productId,product,imageFile);
			
			return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
		}
		
		else
			return new ResponseEntity<>("Error while Updating",HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{	Product product = service.getProductbyId(id);
		if (product != null) 
		{
			
			service.deleteproduct(id);
			return new ResponseEntity<String>("Product Deleted Successfully",HttpStatus.OK);
			
		}
		else
			return new ResponseEntity<String>("Product Not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("products/search")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword)
	{
		
		System.out.println("searching with "+ keyword);
		List<Product> product = service.searchproduct(keyword);
		
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
}
