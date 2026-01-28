package com.example.api_bakery.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Map;
public interface ProductRepo extends JpaRepository<Product, Long> {

  
 
    // Additional methods can be added as per requirements
    @Query(value = "SELECT * FROM product WHERE app_user_id = ?1", nativeQuery = true)
    List<Map<String,Object>> findByAppUserId(Long app_user_id);    
}
