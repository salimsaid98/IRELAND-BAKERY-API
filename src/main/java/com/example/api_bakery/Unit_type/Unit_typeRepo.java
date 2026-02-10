package com.example.api_bakery.Unit_type;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface  Unit_typeRepo extends JpaRepository<Unit_type, Long> {
    @Query(value = "select u.unit_type_id,p.product_id,p.name ,u.unit_measure from unit_type_table u left join product p on p.product_id = u.product_id", nativeQuery = true)
    List<Map<String,Object>> findUnitTypeWithProductName();
}
