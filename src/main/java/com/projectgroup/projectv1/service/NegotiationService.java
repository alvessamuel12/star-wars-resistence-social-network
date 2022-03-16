package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.dto.RebelRequestInventory;
import com.projectgroup.projectv1.model.Rebel;
import com.projectgroup.projectv1.model.negotiation.Negotiation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NegotiationService {

    @Autowired
    private RebelService rebelService;

    public String negotiate(RebelRequestInventory rebelRequestInventory) throws Exception {
        Negotiation negotiation = Negotiation.builder()
                .idRebeldeA(rebelRequestInventory.getIdA())
                .inventarioRebeldeA(rebelRequestInventory.getInventoryA())
                .idRebeldeB(rebelRequestInventory.getIdB())
                .inventarioRebeldeB(rebelRequestInventory.getInventoryB())
                .build();

        Rebel negotiatorA = rebelService.getRebel(negotiation.getIdRebeldeA());
        Rebel negotiatorB = rebelService.getRebel(negotiation.getIdRebeldeB());


        if (negotiatorA == null || negotiatorB == null) {
            return "Rebelde não encontrado. Verifique se preencheu corretamente o ID.";
        } else if (negotiatorA.isTraitor() || negotiatorB.isTraitor()) {
            if (negotiatorA.isTraitor()) {
                return "Rebelde " + negotiatorA.getName() + " é um traidor";
            } else {
                return "Rebelde " + negotiatorB.getName() + " é um traidor";
            }
        } else if (checkStockTrading(negotiation, negotiatorA, negotiatorB) && checkPointsTrading(negotiation)) {
            return makeExchange(negotiation, negotiatorA, negotiatorB);
        }
        return "Não foi possivel fazer a troca.";
    }

    private String makeExchange(Negotiation negotiation, Rebel negociadorA, Rebel negociadorB) {
        if (negotiation.getInventarioRebeldeA().getWater() > 0) {
            negociadorB.getInventory().setWater(negociadorB.getInventory().getWater() + negotiation.getInventarioRebeldeA().getWater());
            negociadorA.getInventory().setWater(negociadorA.getInventory().getWater() - negotiation.getInventarioRebeldeA().getWater());
        }
        if (negotiation.getInventarioRebeldeA().getFood() > 0) {
            negociadorB.getInventory().setFood(negociadorB.getInventory().getFood() + negotiation.getInventarioRebeldeA().getFood());
            negociadorA.getInventory().setFood(negociadorA.getInventory().getFood() - negotiation.getInventarioRebeldeA().getFood());
      }
        if (negotiation.getInventarioRebeldeA().getGun() > 0) {
            negociadorB.getInventory().setGun(negociadorB.getInventory().getGun() + negotiation.getInventarioRebeldeA().getGun());
            negociadorA.getInventory().setGun(negociadorA.getInventory().getGun() - negotiation.getInventarioRebeldeA().getGun());
     }
        if (negotiation.getInventarioRebeldeA().getAmmo() > 0) {
            negociadorB.getInventory().setAmmo(negociadorB.getInventory().getAmmo() + negotiation.getInventarioRebeldeA().getAmmo());
            negociadorA.getInventory().setAmmo(negociadorA.getInventory().getAmmo() - negotiation.getInventarioRebeldeA().getAmmo());
       }
        if (negotiation.getInventarioRebeldeB().getWater() > 0) {
            negociadorA.getInventory().setWater(negociadorA.getInventory().getWater() + negotiation.getInventarioRebeldeB().getWater());
            negociadorB.getInventory().setWater(negociadorB.getInventory().getWater() - negotiation.getInventarioRebeldeB().getWater());
     }
        if (negotiation.getInventarioRebeldeB().getFood() > 0) {
            negociadorA.getInventory().setFood(negociadorA.getInventory().getFood() + negotiation.getInventarioRebeldeB().getFood());
            negociadorB.getInventory().setFood(negociadorB.getInventory().getFood() - negotiation.getInventarioRebeldeB().getFood());
      }
        if (negotiation.getInventarioRebeldeB().getGun() > 0) {
            negociadorA.getInventory().setGun(negociadorA.getInventory().getGun() + negotiation.getInventarioRebeldeB().getGun());
            negociadorB.getInventory().setGun(negociadorB.getInventory().getGun() - negotiation.getInventarioRebeldeB().getGun());
      }
        if (negotiation.getInventarioRebeldeB().getAmmo() > 0) {
            negociadorA.getInventory().setAmmo(negociadorA.getInventory().getAmmo() + negotiation.getInventarioRebeldeB().getAmmo());
            negociadorB.getInventory().setAmmo(negociadorB.getInventory().getAmmo() - negotiation.getInventarioRebeldeB().getAmmo());
      }
        return "Negociação efetuada com sucesso. \n\n" + negociadorA.getName() + "\n\n" + negociadorB.getName();
    }

    private boolean checkPointsTrading(Negotiation negotiation) {
        Integer rebelWaterPointsA = negotiation.getInventarioRebeldeA().getWater() * 2;
        Integer rebelWeaponPointsA = negotiation.getInventarioRebeldeA().getAmmo() * 3;
        Integer rebelFoodPointsA = negotiation.getInventarioRebeldeA().getGun() * 4;
        Integer rebelAmmoPointsA = negotiation.getInventarioRebeldeA().getFood();
        int rebelTotalPointsA = rebelAmmoPointsA + rebelFoodPointsA + rebelWeaponPointsA + rebelWaterPointsA;

        Integer rebelWaterPointsB = negotiation.getInventarioRebeldeB().getWater() * 2;
        Integer rebelWeaponPointsB = negotiation.getInventarioRebeldeB().getAmmo() * 3;
        Integer rebelFoodPointsB = negotiation.getInventarioRebeldeB().getGun() * 4;
        Integer rebelAmmoPointsB = negotiation.getInventarioRebeldeB().getFood();
        int rebelTotoalPointsB = rebelAmmoPointsB + rebelFoodPointsB + rebelWeaponPointsB + rebelWaterPointsB;

        return rebelTotalPointsA == rebelTotoalPointsB;
    }

    private boolean checkStockTrading(Negotiation negotiation, Rebel negociadorA, Rebel negociadorB) {
        return negotiation.getInventarioRebeldeA().getWater() <= negociadorA.getInventory().getWater() &&
                negotiation.getInventarioRebeldeA().getGun() <= negociadorA.getInventory().getGun() &&
                negotiation.getInventarioRebeldeA().getFood() <= negociadorA.getInventory().getFood() &&
                negotiation.getInventarioRebeldeA().getAmmo() <= negociadorA.getInventory().getAmmo() &&
                negotiation.getInventarioRebeldeB().getWater() <= negociadorB.getInventory().getWater() &&
                negotiation.getInventarioRebeldeB().getGun() <= negociadorB.getInventory().getGun() &&
                negotiation.getInventarioRebeldeB().getFood() <= negociadorB.getInventory().getFood() &&
                negotiation.getInventarioRebeldeB().getAmmo() <= negociadorB.getInventory().getAmmo();
    }

}
