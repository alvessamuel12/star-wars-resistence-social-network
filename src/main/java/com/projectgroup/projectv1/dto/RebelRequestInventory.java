package com.projectgroup.projectv1.dto;

import com.projectgroup.projectv1.model.inventory.Inventory;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RebelRequestInventory {
    private UUID idA;
    private Inventory inventoryA;
    private UUID idB;
    private Inventory inventoryB;
}

