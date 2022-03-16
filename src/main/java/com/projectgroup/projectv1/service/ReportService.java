package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.model.Rebel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectgroup.projectv1.model.report.Report;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private RebelService rebelService;

    DecimalFormat formato = new DecimalFormat("#.##");

    public Report getReport(){
        Report report = new Report();

        Double totalTraitor = 0d;
        Double totalRebel = 0d;
        List<Rebel> rebels = rebelService.getAllRebels();

        for (Rebel rebel : rebels) {
            totalRebel++;
            if (rebel.isTraitor()) {
                totalTraitor++;
            }
        }

        report.setPercentTraitors((totalTraitor / totalRebel) * 100 );
        report.setPercentRebels((1 - (totalTraitor / totalRebel)) * 100);

        return report;
    }

}
