package com.projectgroup.projectv1.service;

import com.projectgroup.projectv1.dto.RebelRequest;
import com.projectgroup.projectv1.model.DBRebel;
import com.projectgroup.projectv1.model.Location;
import com.projectgroup.projectv1.model.Rebel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class RebelService {

    private final DBRebel db = new DBRebel();

    public List<Rebel> getAllRebels() {
        log.info("Buscando todos os Rebeldes");
        return db.showAll();
    }

    public Rebel getRebel(UUID id) throws Exception {
        log.info("Buscando o rebelde id: "+ id );
        return db.findRebel(id);
    }

    public Rebel addRebel(RebelRequest rebelRequest) {

        Rebel rebel = new Rebel(
                UUID.randomUUID(),
                rebelRequest.getName(),
                rebelRequest.getAge(),
                rebelRequest.getGender(),
                rebelRequest.getInventory()
        );
        log.info("Adicionando o rebelde:"+rebel);
        db.add(rebel);
        return rebel;
    }


    public Rebel updateLocation(UUID id, Location location) throws Exception {
        log.info("Atualizando alocalizaçao do rebelde id: "+ id);
        return db.updateLocation(id, location);
    }

    public Rebel reportRebel (UUID id) throws Exception {
        log.info("Reportando rebelde id: "+ id);
        return db.reportRebel(id);
    }


}
