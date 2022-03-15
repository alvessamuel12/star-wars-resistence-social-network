package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.model.Rebel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ReportsService {

    private final RebelService rebelService;

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

     return ">>>>> RELATÓRIO <<<<< \n" +
                "O total de rebeldes é: " + (contRebel - contTraitor) + "\n" +
                "O total de traidores é: " + contTraitor + "\n" +
                "O percentual de traidores é: " + (contTraitor / contRebel) * 100 + "%\n" +
                "O percentual de total rebeldes é: " + (1 - (contTraitor / contRebel)) * 100 + "%\n" +
                "\n";
    }
}
