package com.projectgroup.projectv1.controller;

import com.projectgroup.projectv1.dto.RebelRequest;
import com.projectgroup.projectv1.dto.RebelResponse;
import com.projectgroup.projectv1.model.Location;
import com.projectgroup.projectv1.model.Rebel;
import com.projectgroup.projectv1.service.RebelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rebel")
public class RebelController {

    @Autowired
    RebelService rebelService;

    @GetMapping
    public ResponseEntity<List<RebelResponse>> showRebels() {
        return ResponseEntity.ok(RebelResponse.toResponse(rebelService.getAllRebels()));
    };

    @GetMapping("/{id}")
    public ResponseEntity<RebelResponse> showRebel(@PathVariable UUID id) {
        Rebel rebel = rebelService.getRebel(id);

        return ResponseEntity.ok(new RebelResponse(rebel));
    }

    @PostMapping
    public ResponseEntity<RebelResponse> addRebel(@RequestBody RebelRequest rebelRequest, UriComponentsBuilder uriBuilder) {
        Rebel rebel = rebelService.addRebel(rebelRequest);

        URI uri = uriBuilder.path("/rebel/{id}").buildAndExpand(rebel.getId()).toUri();
        return ResponseEntity.created(uri).body(new RebelResponse(rebel));
    }

    @PatchMapping("/{id}/location")
    public ResponseEntity<RebelResponse> updateLocation(@PathVariable UUID id, @RequestBody Location location) {
        Rebel rebel = rebelService.updateLocation(id, location);

        return ResponseEntity.ok(new RebelResponse(rebel));
    }

    @PatchMapping("/{id}/report")
    public ResponseEntity<RebelResponse> reportRebel(@PathVariable UUID id) {
        Rebel rebel = rebelService.reportRebel(id);

        return ResponseEntity.ok(new RebelResponse(rebel));
    }
}
