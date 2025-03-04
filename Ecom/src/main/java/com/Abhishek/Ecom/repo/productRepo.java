package com.Abhishek.Ecom.repo;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.Abhishek.Ecom.model.Product;


@Repository
public interface productRepo extends JpaRepository<Product, Integer>

{
	@Query("SELECT p FROM Product p WHERE"+" LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR"+" LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+"LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword,'%'))")
	
	List<Product> searchproducts(@Param("keyword") String keyword);


}
