package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.dto.RebelRequest;
import com.projectgroup.projectv1.dto.RebelRequestInventory;

import com.projectgroup.projectv1.model.Rebel;
import com.projectgroup.projectv1.model.inventory.Inventory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class NegotiationServiceTest {

    @Autowired
    private MockMvc mockMvc;

    
    private RebelService rebelService = new RebelService();

    @InjectMocks
    private NegotiationService negotiationService = new NegotiationService(this.rebelService);

    @Test
    public void mustFailOnNegotiateWhenThePointsDontMatch() throws Exception {
        RebelRequest rebelRequestA = new RebelRequest(
            "Arthur",
            19,
            "male",
            new Inventory(11, 5, 7, 9)
        );
        Rebel rebelA = rebelService.addRebel(rebelRequestA);

        RebelRequest rebelRequestB = new RebelRequest(
            "Ana",
            26,
            "female",
            new Inventory(9, 6, 12, 14)
        );
        Rebel rebelB = rebelService.addRebel(rebelRequestB);

        negotiationService.negotiate(new RebelRequestInventory(rebelA.getId(), rebelA.getInventory(), rebelB.getId(), rebelB.getInventory()));

        Assertions.assertEquals(rebelA, rebelService.getRebel(rebelA.getId()));
        Assertions.assertEquals(rebelB, rebelService.getRebel(rebelB.getId()));
    }

    @Test
    public void mustNegotiateInventoryBetweenValidInventories() throws Exception {
        RebelRequest rebelRequestA = new RebelRequest(
            "Arthur",
            19,
            "male",
            new Inventory(5, 3, 2, 3)
        );
        Rebel rebelBeforeNegotiationA = rebelService.addRebel(rebelRequestA);
        Inventory inventoryA = new Inventory(
                rebelBeforeNegotiationA.getInventory().getGun(),
                rebelBeforeNegotiationA.getInventory().getAmmo(),
                rebelBeforeNegotiationA.getInventory().getWater(),
                rebelBeforeNegotiationA.getInventory().getFood());


        RebelRequest rebelRequestB = new RebelRequest(
            "Ana",
            26,
            "female",
            new Inventory(3, 4, 5, 2)
        );
        Rebel rebelBeforeNegotiationB = rebelService.addRebel(rebelRequestB);
        Inventory inventoryB = new Inventory(
                rebelBeforeNegotiationB.getInventory().getGun(),
                rebelBeforeNegotiationB.getInventory().getAmmo(),
                rebelBeforeNegotiationB.getInventory().getWater(),
                rebelBeforeNegotiationB.getInventory().getFood());

        negotiationService.negotiate(new RebelRequestInventory(rebelBeforeNegotiationA.getId(), rebelBeforeNegotiationA.getInventory(), rebelBeforeNegotiationB.getId(), rebelBeforeNegotiationB.getInventory()));


        Assertions.assertNotEquals(inventoryA, rebelService.getRebel(rebelBeforeNegotiationA.getId()).getInventory());
        Assertions.assertNotEquals(inventoryB, rebelService.getRebel(rebelBeforeNegotiationB.getId()).getInventory());
    }
}
