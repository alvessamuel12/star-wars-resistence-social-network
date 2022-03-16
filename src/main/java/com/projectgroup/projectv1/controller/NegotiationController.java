package com.projectgroup.projectv1.controller;

import com.projectgroup.projectv1.dto.RebelRequestInventory;
import com.projectgroup.projectv1.service.NegotiationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/negotiation")
public class NegotiationController {

    @Autowired
    NegotiationService negotiationService;

    @PostMapping
    private String negotiate(@RequestBody @Valid RebelRequestInventory rebelRequestInventory) throws Exception {
        return negotiationService.negotiate(rebelRequestInventory);
    }
}
