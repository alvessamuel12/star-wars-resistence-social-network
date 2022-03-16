package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.model.Rebel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ReportsService {

    @Autowired
    private RebelService rebelService;

    public String reportRebels( ) {
        Double contTraitor = 0d;
        Double contRebel = 0d;
        List<Rebel> rebels = rebelService.getAllRebels();
        for (Rebel rebel : rebels) {
            contRebel++;
            if (rebel.isTraitor()) {
                contTraitor++;
            }
        }
        return null;
    }





}
