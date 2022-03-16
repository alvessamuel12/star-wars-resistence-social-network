package com.projectgroup.projectv1.controller;

import com.projectgroup.projectv1.model.Report;
import com.projectgroup.projectv1.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("/all-reports")
@Controller
@RequiredArgsConstructor
public class ReportsController {

    @Autowired
    private ReportsService reportsService;

    @GetMapping
    public Report getRelatorio() throws IOException {
        return ReportsService.getRelatorio();
    }
}
