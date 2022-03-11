package com.projectgroup.projectv1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
}
