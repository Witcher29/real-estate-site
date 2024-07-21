package com.web_site.real_estate.controllers;

import com.web_site.real_estate.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/create")
    public String getAdminForm() {
        return "administratorLogin";
    }
    @PostMapping("/admin/create")
    public String createAdmin(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        adminService.createAdmin(username, password);
        return "redirect:/admin";
    }
}