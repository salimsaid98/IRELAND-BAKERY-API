package com.example.api_bakery.Roles;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("api/Role")
public class RoleController {
 
    private final RoleServices roleServices;

    public RoleController(RoleServices  roleServices){
        this.roleServices = roleServices;

    }
@PostMapping("/AddRoles")
    public Role addRole(@RequestBody Role role) {
       Role role2 = roleServices.createRole(role);
       return role2;
    }
@GetMapping("/getAllRoles")
    public List<Role> getAllRoles() {
        return roleServices.getAllRoles();
    }
    
   @GetMapping("/getRoleNameByAppUserId/{app_user_id}")
    public List<Map<String,Object>> getRoleNameByAppUserId(@PathVariable Long app_user_id) {
        return roleServices.findRoleNameByAppUserId(app_user_id);
    }



}
