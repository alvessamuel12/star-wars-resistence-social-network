package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.model.Rebel;
import com.projectgroup.projectv1.model.negotiation.Negotiation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class NegotiationService {
    private final RebelService rebelService;

    public String negotiate(Negotiation negotiation) {
        Rebel negociadorA = rebelService.getRebel(negotiation.getIdRebeldeA());
        Rebel negociadorB = rebelService.getRebel(negotiation.getIdRebeldeB());

        negociadorA =rebelService.getRebel(UUID.fromString("27dacf13-4d15-46cf-8f10-bcdf9d127413"));
        negociadorB = rebelService.getRebel(UUID.fromString("dafd1c4d-528f-4be1-9aff-61cc0ce9d1a6"))

        if (negociadorA == null || negociadorB == null) {
            return "Rebelde não encontrado. Verifique se preencheu corretamente o ID.";
        } else if (checkStockTrading(negotiation, negociadorA, negociadorB) && checkPointsTrading(negotiation)) {
            return makeExchange(negotiation, negociadorA, negociadorB);
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

        return "Negociação efetuada com sucesso. \n\n" + negociadorA + "\n\n" + negociadorB;
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

        return rebelTotalPointsA ==rebelTotoalPointsB;
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
