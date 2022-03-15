package com.projectgroup.projectv1.negotiation;

import com.projectgroup.projectv1.model.Location;
import com.projectgroup.projectv1.model.Rebel;
import com.projectgroup.projectv1.model.inventory.Inventory;
import com.projectgroup.projectv1.service.NegotiationService;
import com.projectgroup.projectv1.service.RebelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class Negotiation {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NegotiationService negotiationService;
    private RebelService rebelService;

    private Rebel rebeldeA() {
        Rebel rebeldeA= new Rebel();
        rebeldeA.setId(UUID.randomUUID());
        rebeldeA.setName("Arthur");
        rebeldeA.setAge(19);
        rebeldeA.setGender("MASCULINO");
        Location localizacao = new Location();
        rebeldeA.setLocation(localizacao);
        Inventory inventario = new Inventory();
        inventario.setGun(10);
        inventario.setAmmo(10);
        inventario.setWater(10);
        inventario.setFood(10);
        rebeldeA.setInventory(inventario);
        return rebeldeA;
    }
    private Rebel rebeldeB() {
        Rebel rebeldeB= new Rebel();
        rebeldeB.setId(UUID.randomUUID());
        rebeldeB.setName("Anna");
        rebeldeB.setAge(26);
        rebeldeB.setGender("FEMININO");
        Location localizacao = new Location();
        rebeldeB.setLocation(localizacao);
        Inventory inventario = new Inventory();
        inventario.setGun(10);
        inventario.setAmmo(10);
        inventario.setWater(10);
        inventario.setFood(10);
        rebeldeB.setInventory(inventario);
        return rebeldeB;
    }

    @Test
    public void negotiate(){
    }
}