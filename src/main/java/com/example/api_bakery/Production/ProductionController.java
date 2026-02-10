package com.example.api_bakery.Production;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/productions")
public class ProductionController {
    private final ProductionServices productionServices;    
    public ProductionController(ProductionServices productionServices) {
        this.productionServices = productionServices;
    }
@PostMapping("/Create_production")
    public ResponseEntity<Production> createProduction(@RequestBody Production production) {
        Production savedProduction = productionServices.saveProduction(production);
        return ResponseEntity.status(201).body(savedProduction);
    }
@GetMapping("/getAllProductions")
    public ResponseEntity<List<Production>> getAllProductions() {
        List<Production> productionList = productionServices.getAllProductions();
        return ResponseEntity.ok(productionList);
    }   

@GetMapping("/production/{id}")
    public ResponseEntity<Production> getProductionById(Long id) {
        Production production = productionServices.getProductionById(id);
        if (production != null) {
            return ResponseEntity.ok(production);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

@DeleteMapping("/production/delete/{id}")
    public ResponseEntity<Void> deleteProduction(Long id) {
        productionServices.deleteProduction(id);
        return ResponseEntity.noContent().build();
    }

@PutMapping("/production/update/{id}")
    public ResponseEntity<Production> updateProduction(Long id, @RequestBody Production productionDetails) {
        Production updatedProduction = productionServices.updateProduction(id, productionDetails);
        if (updatedProduction != null) {
            return ResponseEntity.ok(updatedProduction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
@GetMapping("/getTotalProductionByDay/{app_user_id}")
    public ResponseEntity<List<Map<String, Object>>> getTotalProductionByDay(@PathVariable Long app_user_id) {
        List<Map<String, Object>> result = productionServices.findTotalProductionByDay(app_user_id  );
        return ResponseEntity.ok(result);
    }

@GetMapping("/getTotalProductionByDayForUser/{app_user_id}/{production_date}/{name}")
    public ResponseEntity<List<Map<String, Object>>> getTotalProductionByDayForUser(@PathVariable Long app_user_id, @PathVariable String production_date, @PathVariable String name) {
        List<Map<String, Object>> result = productionServices.findTotalProductionByDayForUser(app_user_id, production_date, name);
        return ResponseEntity.ok(result);
    }
}
