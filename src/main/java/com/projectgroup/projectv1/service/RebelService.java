package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.dto.RebelRequest;
import com.projectgroup.projectv1.exceptions.NotFoundException;
import com.projectgroup.projectv1.model.DBRebel;
import com.projectgroup.projectv1.model.Location;
import com.projectgroup.projectv1.model.Rebel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RebelService {

    private final DBRebel db = new DBRebel();

    public List<Rebel> getAllRebels() {
        return db.showAll();
    }


    public Rebel getRebel(UUID id) throws NotFoundException {
        Optional<Rebel> rebel = db.findRebel(id);
        if (rebel.isPresent()) {
            return rebel.get();
        } else {
            throw new NotFoundException("User not found.");
        }
    }

    public Rebel addRebel(RebelRequest rebelRequest) {
        Rebel rebel = new Rebel(
                UUID.randomUUID(),
                rebelRequest.getName(),
                rebelRequest.getAge(),
                rebelRequest.getGender()
        );

        db.add(rebel);
        return rebel;
    }


    public Rebel updateLocation(UUID id, Location location) throws Exception {
        Optional<Rebel> rebel = db.updateLocation(id, location);
        if (rebel.isPresent()) {
            return rebel.get();
        } else {
            throw new NotFoundException("User not found.");
        }
    }

    public Rebel reportRebel (UUID id) throws Exception {
        Optional<Rebel> rebel = db.reportRebel(id);
        if (rebel.isPresent()) {
            return rebel.get();
        } else {
            throw new NotFoundException("User not found.");
        }
    }


}
