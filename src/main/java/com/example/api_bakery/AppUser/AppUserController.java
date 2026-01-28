package com.example.api_bakery.AppUser;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins = "*") // Allow all origins for CORS
@RestController
@RequestMapping("api/appUsers")
public class AppUserController {
    private final AppUserServices appUserServices;
    public AppUserController(AppUserServices appUserServices) {
        this.appUserServices = appUserServices;
    }

@GetMapping("login")
    public ResponseEntity<AppUser> login(String username, String password) {
        AppUser user = appUserServices.login(username, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).build(); // Return 401 Unauthorized if login fails
        }
    }

@PostMapping("register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
        AppUser newUser = appUserServices.saveAppUser(appUser);
        return ResponseEntity.ok(newUser);
    }

@GetMapping("getUserById")
    public ResponseEntity<AppUser> getUserById(Long id) {
        AppUser user = appUserServices.getAppUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if user does not exist
        }
    }

@GetMapping("getAllUsers")
    public ResponseEntity<java.util.List<AppUser>> getAllUsers() {
        java.util.List<AppUser> users = appUserServices.getAllAppUsers();
        return ResponseEntity.ok(users);
    }

@DeleteMapping("deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        appUserServices.deleteAppUser(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
    }
}
