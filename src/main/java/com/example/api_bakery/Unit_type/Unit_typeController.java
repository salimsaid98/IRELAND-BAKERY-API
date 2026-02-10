package com.example.api_bakery.Unit_type;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/unit_types")
public class Unit_typeController {

    private final Unit_typeService unit_typeServices;
    public Unit_typeController(Unit_typeService unit_typeServices) {
        this.unit_typeServices = unit_typeServices;
    }
    
    @PostMapping("/Create_unit_type")
    public ResponseEntity<Unit_type> createUnitType(@RequestBody Unit_type unit_type) {
        return ResponseEntity.ok(unit_typeServices.saveUnitType(unit_type));
    }   

    @GetMapping("/getAllUnitTypes")
    public ResponseEntity<List<Unit_type>> getAllUnitTypes() {
        return ResponseEntity.ok(unit_typeServices.getAllUnitTypes());
    }

    @GetMapping("/unit_type/{id}")
    public ResponseEntity<Unit_type> getUnitTypeById(Long id) {
        Unit_type unit_type = unit_typeServices.getUnitTypeById(id);
        if (unit_type != null) {
            return ResponseEntity.ok(unit_type);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/unit_type/delete/{id}")
    public ResponseEntity<Void> deleteUnitType(Long id) {
        unit_typeServices.deleteUnitType(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/unit_type/update/{id}")
    public ResponseEntity<Unit_type> updateUnitType(Long id, @RequestBody Unit_type unit_typeDetails) {
        Unit_type updatedUnitType = unit_typeServices.updateUnitType(id, unit_typeDetails);
        if (updatedUnitType != null) {
            return ResponseEntity.ok(updatedUnitType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }   

    @GetMapping("/getUnitTypeWithProductName")
    public ResponseEntity<List<java.util.Map<String, Object>>> getUnitTypeWithProductName() {
        List<java.util.Map<String, Object>> result = unit_typeServices.findUnitTypeWithProductName();
        return ResponseEntity.ok(result);
    }
}
