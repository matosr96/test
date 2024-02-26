package com.essanar.test.services.affiliate;

import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.repository.AffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetAllAffiliatesService {
    private final AffiliateRepository affiliateRepository;

    @Autowired
    public GetAllAffiliatesService(AffiliateRepository affiliateRepository){
        this.affiliateRepository = affiliateRepository;
    }

    @Bean
    public List<Affiliate> getAllAffiliates(){
        return affiliateRepository.findAllActiveAffiliates();
    }
}
