package com.projectgroup.projectv1.model.negotiation;

import com.projectgroup.projectv1.model.inventory.Inventory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Negotiation {
    private UUID idRebeldeA;
    private Inventory inventarioRebeldeA;
    private UUID idRebeldeB;
    private Inventory inventarioRebeldeB;
}
