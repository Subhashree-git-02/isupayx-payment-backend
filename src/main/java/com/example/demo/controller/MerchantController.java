package com.example.demo.controller;

import com.example.demo.entity.Merchant;
import com.example.demo.service.MerchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping
    public ResponseEntity<Merchant> createMerchant(@RequestBody Merchant merchant) {
        Merchant savedMerchant = merchantService.createMerchant(merchant);
        return ResponseEntity.ok(savedMerchant);
    }

    @GetMapping("/{merchantId}")
    public ResponseEntity<Merchant> getMerchant(@PathVariable String merchantId) {

        return merchantService.getMerchantById(merchantId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}