package com.projectgroup.projectv1.model.report;

import com.projectgroup.projectv1.model.Rebel;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
public class Report {

    private double percentRebels;
    private double percentTraitors;
    private double averageGun;
    private double averageAmmo;
    private double averageWater;
    private double averageFood;
}
