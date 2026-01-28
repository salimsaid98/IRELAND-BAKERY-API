package com.example.api_bakery.Product;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class ProductServices {
    private final ProductRepo productRepo;
    private final String uploadDir = "src/main/resources/static/uploads/";

    public ProductServices(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product, MultipartFile image) {
        if (image != null && !image.isEmpty()) {
            try {
                String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, image.getBytes());
                product.setImage("/uploads/" + fileName);
            } catch (IOException e) {
                throw new RuntimeException("Failed to store image", e);
            }
        }
        return productRepo.save(product); // Save the new product
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product existingProduct = productRepo.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(productDetails.getName());
            existingProduct.setOriginalPrice(productDetails.getOriginalPrice());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setInStock(productDetails.isInStock());
            existingProduct.setImage(productDetails.getImage());
            existingProduct.setRating(productDetails.getRating());
            existingProduct.setSelling_price(productDetails.getSelling_price());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setQuantity(productDetails.getQuantity());
            return productRepo.save(existingProduct); // Update the existing product
        }
        return null; // Return null if the product does not exist
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id); // Delete the product by ID
    }   
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null); // Retrieve product by ID
    }   
    public List<Product> getAllProducts() {
        return productRepo.findAll(); // Retrieve all products
    }   
    public  List<Map<String, Object>> getProductsByAppUserId(Long app_user_id) {
        return productRepo.findByAppUserId(app_user_id); // Retrieve products by app user ID
    }
}
