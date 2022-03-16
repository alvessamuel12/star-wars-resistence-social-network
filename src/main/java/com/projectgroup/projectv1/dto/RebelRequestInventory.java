package com.projectgroup.projectv1.dto;

import com.projectgroup.projectv1.model.inventory.Inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class RebelRequestInventory {
    @com.projectgroup.projectv1.utils.validators.uuid.UUID
    private UUID idA;
    private Inventory inventoryA;
    @com.projectgroup.projectv1.utils.validators.uuid.UUID
    private UUID idB;
    private Inventory inventoryB;
}

