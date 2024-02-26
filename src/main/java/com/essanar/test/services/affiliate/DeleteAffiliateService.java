package com.essanar.test.services.affiliate;

import com.essanar.test.repository.AffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAffiliateService {
    private final AffiliateRepository affiliateRepository;

    @Autowired
    public DeleteAffiliateService(AffiliateRepository affiliateRepository){
        this.affiliateRepository = affiliateRepository;
    }

    public void deleteAffiliate(Long id) {
        affiliateRepository.deleteById(id);
    }
}
