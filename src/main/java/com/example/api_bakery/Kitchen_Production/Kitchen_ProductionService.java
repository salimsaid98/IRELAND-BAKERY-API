package com.example.api_bakery.Kitchen_Production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Kitchen_ProductionService {
    @Autowired
    private final Kitchen_ProductionRepo kitchenProductionRepo;
    public Kitchen_ProductionService(Kitchen_ProductionRepo kitchenProductionRepo) {
        this.kitchenProductionRepo = kitchenProductionRepo;
    }
    public Kitchen_Production saveKitchenProduction(Kitchen_Production kitchenProduction) {
        return kitchenProductionRepo.save(kitchenProduction);
    }
    public java.util.List<Kitchen_Production> getAllKitchenProductions() {
        return kitchenProductionRepo.findAll();
    }
    public Kitchen_Production getKitchenProductionById(Long id) {
        return kitchenProductionRepo.findById(id).orElse(null);
    }
    public void deleteKitchenProduction(Long id) {
        kitchenProductionRepo.deleteById(id);
    }
        public Kitchen_Production updateKitchenProduction(Long id, Kitchen_Production kitchenProductionDetails) {
        return kitchenProductionRepo.findById(id).map(kitchenProduction -> {    
            kitchenProduction.setApp_user_id(kitchenProductionDetails.getApp_user_id());
            kitchenProduction.setDamaged_qty(kitchenProductionDetails.getDamaged_qty());
            kitchenProduction.setProduct_id(kitchenProductionDetails.getProduct_id());
            kitchenProduction.setApp_user_id(kitchenProductionDetails.getApp_user_id());
            kitchenProduction.setFinished_qty(kitchenProductionDetails.getFinished_qty());
            kitchenProduction.setRemarks(kitchenProductionDetails.getRemarks());
            kitchenProduction.setProductionDate(kitchenProductionDetails.getProductionDate());
            return kitchenProductionRepo.save(kitchenProduction);
        }).orElse(null);
    }


}
