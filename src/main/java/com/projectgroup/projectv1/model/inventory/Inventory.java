package com.projectgroup.projectv1.model.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private Integer gun = 0;
    private Integer ammo = 0;
    private Integer water = 0;
    private Integer food = 0;
}
