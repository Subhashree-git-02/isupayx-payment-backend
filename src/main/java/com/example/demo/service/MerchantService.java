package com.example.demo.service;

import com.example.demo.entity.Merchant;
import com.example.demo.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public Merchant createMerchant(Merchant merchant) {

    if (merchantRepository.existsByMerchantId(merchant.getMerchantId())) {
        throw new RuntimeException("Merchant already exists");
    }

    return merchantRepository.save(merchant);
}

    public Optional<Merchant> getMerchantById(String merchantId) {
        return merchantRepository.findByMerchantId(merchantId);
    }
}