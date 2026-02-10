package com.example.api_bakery.Roles;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepo  extends JpaRepository<Role,Long>{
    @Query(value = "select r.name from role r LEFT JOIN app_user a ON a.role_id = r.role_id where a.app_user_id = ?1",nativeQuery = true)
    List<Map<String,Object>> findRoleNameByAppUserId(@Param("app_user_id") Long app_user_id);
}
