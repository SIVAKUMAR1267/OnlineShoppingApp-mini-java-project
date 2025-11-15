package services;

import entities.Admin;
import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private List<Admin> adminList;
    
    public AdminService() {
        this.adminList = new ArrayList<>();
    }

    public void addAdmin(Admin admin) {
        adminList.add(admin);
    }

    public List<Admin> getAdmins() {
        return adminList;
    }
    
}