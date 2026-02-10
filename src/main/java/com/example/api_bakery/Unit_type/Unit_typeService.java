package com.example.api_bakery.Unit_type;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Unit_typeService {
    private final Unit_typeRepo unit_typeRepo;
    public Unit_typeService(Unit_typeRepo unit_typeRepo) {
        this.unit_typeRepo = unit_typeRepo;
    }
    public Unit_type saveUnitType(Unit_type unit_type) {
        return unit_typeRepo.save(unit_type);
    }
    public java.util.List<Unit_type> getAllUnitTypes() {
        return unit_typeRepo.findAll();
    }
    public Unit_type getUnitTypeById(Long id) {
        return unit_typeRepo.findById(id).orElse(null);
    }
    public void deleteUnitType(Long id) {
        unit_typeRepo.deleteById(id);
    }
    public Unit_type updateUnitType(Long id, Unit_type unit_typeDetails) {
        return unit_typeRepo.findById(id).map(unit_type -> {
            unit_type.setUnit_measure(unit_typeDetails.getUnit_measure());
            unit_type.setProduct_id(unit_typeDetails.getProduct_id());
            unit_type.setApp_user_id(unit_typeDetails.getApp_user_id());
            return unit_typeRepo.save(unit_type);
        }).orElse(null);
    }
     
    public List<java.util.Map<String, Object>> findUnitTypeWithProductName() {
        return unit_typeRepo.findUnitTypeWithProductName();
    }
}
