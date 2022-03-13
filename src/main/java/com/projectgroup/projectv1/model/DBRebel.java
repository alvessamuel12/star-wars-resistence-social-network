package com.projectgroup.projectv1.model;

import com.projectgroup.projectv1.dto.RebelRequestInventory;

import java.util.*;

public class DBRebel {
    private final List<Rebel> rebels = new ArrayList<>();

    public void add (Rebel rebel) {
        this.rebels.add(rebel);
    }

    public Rebel findRebel (UUID id) {
        return this.rebels.stream()
                .filter(rebel -> id.equals(rebel.getId()))
                .findAny()
                .orElse(null);
    }

    public List<Rebel> showAll(){
        return this.rebels;
    }

    public Rebel updateLocation (UUID id, Location location){
        Rebel rebel = findRebel(id);
        rebel.setLocation(location);
        return rebel;
    }

    public Rebel reportRebel (UUID id) {
        Rebel rebel = findRebel(id);

        rebel.addReport();
        if (rebel.getReportCounts() >= 3) {
            rebel.setTraitor(true);
        }

        return rebel;
    }

//    public Rebel updateRebelInventory(UUID id, RebelRequestInventory rebelRequestInventory) throws Exception {
//        rebels.stream().filter(rebel -> Objects.equals(rebel.getId(),id)).forEach(rebel->{
//            rebel.getInventory().setWater(rebelRequestInventory.getWater());
//            rebel.getInventory().setGun(rebelRequestInventory.getGun());
//            rebel.getInventory().setAmmo(rebelRequestInventory.getAmmo());
//            rebel.getInventory().setFood(rebelRequestInventory.getFood());
//        });
//        return rebelDetails(id);
//    }

//    private Rebel rebelDetails(UUID id) throws Exception {
//        Optional<Rebel> resultRebel = rebels.stream().filter(rebel -> Objects.equals(rebel.getId(),id)).findAny();
//        if (resultRebel.isPresent()){
//            return resultRebel.get();
//        }else {
//            throw new Exception("Rebelde não encontrado!");
//        }
//    }
}
