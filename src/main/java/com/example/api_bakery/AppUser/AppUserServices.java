package com.example.api_bakery.AppUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServices {
    @Autowired
    private final AppUserRepo appUserRepo;
    public AppUserServices(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public AppUser saveAppUser(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    public AppUser getAppUserById(Long id) {
        return appUserRepo.findById(id).orElse(null);
    }   
    public void deleteAppUser(Long id) {
        appUserRepo.deleteById(id);
    }
    public AppUser updateAppUser(Long id, AppUser appUserDetails) {
        AppUser appUser = getAppUserById(id);
        if (appUser != null) {
            appUser.setUsername(appUserDetails.getUsername());
            appUser.setPassword(appUserDetails.getPassword());
            return appUserRepo.save(appUser);
        }
        return null;
    }
    public List<AppUser> getAllAppUsers() {
        return appUserRepo.findAll();
    }

    public AppUser login(String username, String password) {
        List<AppUser> users = appUserRepo.findAll();
        for (AppUser user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // Return null if no matching user is found
    }
     
}
