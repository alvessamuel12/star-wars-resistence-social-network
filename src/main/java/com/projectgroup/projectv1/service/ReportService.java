package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.model.Rebel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectgroup.projectv1.model.report.Report;

import java.text.DecimalFormat;
import java.util.List;

@Service
@Slf4j
public class ReportService {

    @Autowired
    private RebelService rebelService;

    public Report getReport(){
    log.info("Gerendo relatorio");
        Report report = new Report();
        List<Rebel> rebels = rebelService.getAllRebels();

        Double totalTraitor = 0d;
        Double totalRebel = 0d;

        Integer amountGun = 0;
        Integer amountAmmo = 0;
        Integer amountWater = 0;
        Integer amountFood = 0;


        for (Rebel rebel : rebels) {
            totalRebel++;
            if (rebel.isTraitor()) {
                totalTraitor++;
            }
        }

        for (Rebel rebel : rebels) {
            if (!rebel.isTraitor()) {
                amountAmmo += rebel.getInventory().getAmmo();
                amountGun += rebel.getInventory().getGun();
                amountWater += rebel.getInventory().getWater();
                amountFood += rebel.getInventory().getFood();
            }
        }


        report.setPercentTraitors((totalTraitor / totalRebel) * 100 );
        report.setPercentRebels((1 - (totalTraitor / totalRebel)) * 100);

        report.setAverageGun(amountGun / (totalRebel - totalTraitor));
        report.setAverageAmmo(amountAmmo / (totalRebel - totalTraitor));
        report.setAverageWater(amountWater / (totalRebel - totalTraitor));
        report.setAverageFood(amountFood / (totalRebel - totalTraitor));

        return report;
    }

}
