package com.example.api_bakery.Production;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductionRepo extends JpaRepository<Production, Long> {
    @Query(value = "SELECT DATE(pt.production_date) AS production_day, pt.product_id, p.name,SUM(pt.total_unit_produce) AS total_produced FROM productions_table pt LEFT JOIN product p ON p.product_id = pt.product_id where pt.app_user_id = :app_user_id GROUP BY DATE(pt.production_date), pt.product_id, p.name  ORDER BY production_day DESC;\r\n" + //
                "", nativeQuery = true)
   List<Map<String, Object>> findTotalProductionByDay(@Param("app_user_id") Long app_user_id);

  @Query(value = """
    SELECT pt.id,p.name, pt.total_unit_produce,ut.unit_measure,pt.quantity
    FROM productions_table pt
    LEFT JOIN product p ON p.product_id = pt.product_id
    left join unit_type_table ut on ut.product_id = pt.product_id
    WHERE pt.app_user_id = :app_user_id and p.name = :name
      AND DATE(pt.production_date) = CAST(:production_date AS DATE)
    ORDER BY pt.production_date DESC
""", nativeQuery = true)
   List<Map<String, Object>> findTotalProductionByDayForUser(@Param("app_user_id") Long app_user_id, @Param("name") String name, @Param("production_date") String production_date);
}
