package com.projectgroup.projectv1.controller;

import com.projectgroup.projectv1.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/all-reports")
@Controller
public class ReportsController {

    @Autowired
    ReportsService reportsService;

    @GetMapping
    public String showReports() {
        return reportsService.reportRebels();
//                reportsService.reportItensRebels() + "\n" +
//                reportsService.reportItensRebelsTraitor();
    }
}
