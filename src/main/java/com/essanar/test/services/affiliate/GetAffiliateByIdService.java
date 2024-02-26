package com.essanar.test.services.affiliate;

import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.repository.AffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class GetAffiliateByIdService {
    private final AffiliateRepository affiliateRepository;

    @Autowired
    public GetAffiliateByIdService(AffiliateRepository affiliateRepository){
        this.affiliateRepository = affiliateRepository;
    }

    /**
     * Obtiene un afiliado por su ID.
     *
     * @param id El ID del afiliado que se va a obtener.
     * @return El afiliado correspondiente al ID proporcionado o null si no se encuentra.
     */
    public Object  getAffiliateById(Long id) {
        Affiliate affiliate = affiliateRepository.findById(id).orElse(null);

        if (affiliate != null) {
            return affiliate;
        } else {
            System.out.println("No se encontró el afiliado con el ID: " + id);
            return "No se encontró el afiliado con el ID: " + id;
        }
    }
}
