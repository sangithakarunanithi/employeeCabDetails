package com.example.employeeCabDetails.controller;

import com.example.employeeCabDetails.entity.CabUsage;
import com.example.employeeCabDetails.service.CabUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CabUsageController {

    @Autowired
    private CabUsageService cabUsageService;

    @GetMapping("/")
    public String showLandingPage() {
        return "landing-page";
    }


    @GetMapping("/cab-usage")
    public String showCabUsageForm(Model model) {
        model.addAttribute("cabUsage", new CabUsage());
        return "cab-usage-form";
    }

    @PostMapping("/saveCabUsage")
    public String saveCabUsage(@ModelAttribute CabUsage cabUsage, Model model) {
        cabUsageService.saveCabUsage(cabUsage);
        model.addAttribute("message", "Cab usage saved successfully.");
        return "cab-usage-form";
    }

    @GetMapping("/employeeCabUsage")
    public String showEmployeeCabUsageForm(Model model) {
        return "employee-cab-usage";
    }

    @PostMapping("/employeeCabUsage")
    public String getEmployeeCabUsage(
            @RequestParam String employeeName,
            @RequestParam String month,
            Model model) {

        LocalDate startDate = LocalDate.parse(month + "-01");
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        List<CabUsage> cabUsages = cabUsageService.getEmployeeCabUsageForMonth(employeeName, startDate, endDate);

        model.addAttribute("cabUsages", cabUsages != null ? cabUsages : new ArrayList<>());
        model.addAttribute("employeeName", employeeName);
        return "employee-cab-usage";
    }


}
