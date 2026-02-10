package com.example.api_bakery.Production;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionServices {
    @Autowired
    private final ProductionRepo productionRepo;
    public ProductionServices(ProductionRepo productionRepo) {
        this.productionRepo = productionRepo;
    }
    public Production saveProduction(Production production) {
        return productionRepo.save(production);
    }

    public java.util.List<Production> getAllProductions() {
        return productionRepo.findAll();
    }
    public Production getProductionById(Long id) {
        return productionRepo.findById(id).orElse(null);
    }
    public void deleteProduction(Long id) {
        productionRepo.deleteById(id);
    }

    public Production updateProduction(Long id, Production productionDetails) {
        return productionRepo.findById(id).map(production -> {
            production.setProductionDate(productionDetails.getProductionDate());
           
            production.setTotal_unit_produce(productionDetails.getTotal_unit_produce());
            production.setProduct_id(productionDetails.getProduct_id());
            production.setApp_user_id(productionDetails.getApp_user_id());
            production.setUnit_type_id(productionDetails.getUnit_type_id());
            return productionRepo.save(production);
        }).orElse(null);
    }       

    public List<Map<String, Object>> findTotalProductionByDay(Long app_user_id) {
        return productionRepo.findTotalProductionByDay(app_user_id);
    }

    public List<Map<String, Object>> findTotalProductionByDayForUser(Long app_user_id, String production_date, String name) {
        return productionRepo.findTotalProductionByDayForUser(app_user_id, name, production_date);
    }
}
