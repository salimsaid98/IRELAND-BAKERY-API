package com.example.api_bakery.Roles;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RoleServices {
    private final RoleRepo roleRepo;

    public RoleServices(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role createRole(Role role) {
        return roleRepo.save(role); // Save the new role
    }

    public Role getRoleById(Long roleId) {
        return roleRepo.findById(roleId).orElse(null); // Retrieve role by ID
    }

    public List<Role> getAllRoles() {
        return roleRepo.findAll(); // Retrieve all roles
    }   
    public Role updateRole(Long roleId, Role roleDetails) {
        Role existingRole = roleRepo.findById(roleId).orElse(null);
        if (existingRole != null) {
            existingRole.setName(roleDetails.getName());
            return roleRepo.save(existingRole); // Update the existing role
        }
        return null; // Return null if the role does not exist
    }
    public void deleteRole(Long roleId) {
        roleRepo.deleteById(roleId); // Delete the role by ID
    }
   
}
