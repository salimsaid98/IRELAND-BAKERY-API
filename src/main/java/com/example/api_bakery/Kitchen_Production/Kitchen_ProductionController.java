package com.example.api_bakery.Kitchen_Production;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/kitchen_production")
public class Kitchen_ProductionController {
    private final Kitchen_ProductionService kitchen_productionServices;    
    public Kitchen_ProductionController(Kitchen_ProductionService kitchen_productionServices) {
        this.kitchen_productionServices = kitchen_productionServices;
    }
    
    @PostMapping("/Create_kitchen_production")
    public ResponseEntity<Kitchen_Production> createKitchenProduction(@RequestBody Kitchen_Production kitchen_production) {
        Kitchen_Production savedKitchenProduction = kitchen_productionServices.saveKitchenProduction(kitchen_production);
        return ResponseEntity.status(201).body(savedKitchenProduction);
    }
    @GetMapping("/getAllKitchenProductions")
    public ResponseEntity<List<Kitchen_Production>> getAllKitchenProductions() {    
        List<Kitchen_Production> kitchen_productionList = kitchen_productionServices.getAllKitchenProductions();
        return ResponseEntity.ok(kitchen_productionList);
    }   
    @GetMapping("/kitchen_production/{id}")
    public ResponseEntity<Kitchen_Production> getKitchenProductionById(Long id) {
        Kitchen_Production kitchen_production = kitchen_productionServices.getKitchenProductionById(id);
        if (kitchen_production != null) {
            return ResponseEntity.ok(kitchen_production);
        } else {
            return ResponseEntity.notFound().build();
        }
    }   
    @DeleteMapping("/kitchen_production/delete/{id}")
    public ResponseEntity<Void> deleteKitchenProduction(Long id) {
        kitchen_productionServices.deleteKitchenProduction(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/kitchen_production/update/{id}")
    public ResponseEntity<Kitchen_Production> updateKitchenProduction(Long id, @RequestBody Kitchen_Production kitchen_productionDetails) {
        Kitchen_Production updatedKitchenProduction = kitchen_productionServices.updateKitchenProduction(id, kitchen_productionDetails);
        if (updatedKitchenProduction != null) {
            return ResponseEntity.ok(updatedKitchenProduction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
}
