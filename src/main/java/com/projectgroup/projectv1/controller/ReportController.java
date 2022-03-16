package com.projectgroup.projectv1.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectgroup.projectv1.service.ReportService;
import com.projectgroup.projectv1.model.report.Report;

@RestController
@AllArgsConstructor
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping
    public Report showReport() {
        return reportService.getReport();
    }

}
