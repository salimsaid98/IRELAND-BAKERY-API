package com.example.api_bakery.Product;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestPart;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductServices productServices;
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }   
@PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product addProduct(@ModelAttribute Product product, @RequestParam(value = "file", required = false) MultipartFile image) {
        return productServices.addProduct(product, image); // Add a new product
    }   


// @PostMapping("/add")
//     public Product addProduct(@RequestBody Product product) {
//         return productServices.addProduct(product); // Add a new product
//     }

@PutMapping("/update")
    public Product updateProduct(Long id, @RequestBody Product  productDetails) {
        return productServices.updateProduct(id, productDetails); // Update an existing product
    }   
@DeleteMapping("/delete")
    public void deleteProduct(Long id) {
        productServices.deleteProduct(id); // Delete a product by ID
    }       
@PostMapping("/getById")
    public Product getProductById(Long id) {
        return productServices.getProductById(id); // Retrieve product by ID
    }
@GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() { 
        return new ResponseEntity<>(productServices.getAllProducts(), HttpStatus.OK); // Retrieve all products
    }
// @PostMapping("/uploadImage")
//     public String uploadImage(@RequestParam("image") MultipartFile image) {
//         return productServices.uploadImage(image);
//     }
}
