//package com.web_site.real_estate.controllers;
//
//import com.web_site.real_estate.models.*;
//import com.web_site.real_estate.repo.*;
//import org.springframework.beans.factory.ListableBeanFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.lang.reflect.ParameterizedType;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class AdminController {
//
//    @Autowired
//    private PropertyRepository propertyRepository;
//
//    @Autowired
//    private ComplexRepository complexRepository;
//
//    @Autowired
//    private DistrictRepository districtRepository;
//
//    @Autowired
//    private DeveloperRepository developerRepository;
//
//    @Autowired
//    private BrokerRepository brokerRepository;
//
//    @Autowired
//    private ContactUsInfoRepository contactUsInfoRepository;
//
//    private enum namesOfTables {Broker, Complex, ContactUsInfo, Developer, District, Property}
//    @GetMapping("/admin")
//    public String admin(Model model) {
//        model.addAttribute("tableNames", Arrays.asList(namesOfTables.values()));
//        return "admin";
//    }
//
//    @GetMapping("/admin/table")
//    public String adminTable(@RequestParam("tableName") String tableName, Model model) throws ClassNotFoundException {
//
//        Class<?> table = Class.forName("com.web_site.real_estate.models." + tableName);
//        List<?> data = getTableData(table);
//        model.addAttribute("tableData", data);
//
//        model.addAttribute("tableNames", Arrays.asList(namesOfTables.values()));
//        return "adminTable";
//    }
//
//    private List<?> getTableData(Class<?> table) {
//        if (table.equals(Broker.class)) {
//            return brokerRepository.findAll();
//        } else if (table.equals(Complex.class)) {
//            return complexRepository.findAll();
//        } else if (table.equals(ContactUsInfo.class)) {
//            return contactUsInfoRepository.findAll();
//        } else if (table.equals(Developer.class)) {
//            return developerRepository.findAll();
//        } else if (table.equals(District.class)) {
//            return districtRepository.findAll();
//        } else if (table.equals(Property.class)) {
//            return propertyRepository.findAll();
//        } else {
//            throw new IllegalArgumentException("No repository found for class: " + table.getName());
//        }
//    }
//}
