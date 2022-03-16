package com.projectgroup.projectv1.model;


import java.util.*;

public class DBRebel {
    private final List<Rebel> rebels = new ArrayList<>();

    public void add(Rebel rebel) {
        this.rebels.add(rebel);
    }

    public Optional<Rebel> findRebel (UUID id) {
        return rebels.stream().filter(rebel -> Objects.equals(rebel.getId(),id)).findAny();
    }

    public List<Rebel> showAll(){
        return this.rebels;
    }

    public Optional<Rebel> updateLocation (UUID id, Location location) {
        Optional<Rebel> rebel = findRebel(id);
        rebel.ifPresent(value -> value.setLocation(location));
        return rebel;
    }

    public Optional<Rebel> reportRebel (UUID id) {
        Optional<Rebel> rebel = findRebel(id);

        if (rebel.isPresent()) {
            rebel.get().addReport();
            if (rebel.get().getReportCounts() >= 3) {
                rebel.get().setTraitor(true);
            }
        }

        return rebel;
    }
}
