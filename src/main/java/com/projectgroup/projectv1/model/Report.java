package com.projectgroup.projectv1.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Report {
    private double traitorReport;
    private double rebelReport;
    private float inventoryReport;
    private int lostPoints;
}
