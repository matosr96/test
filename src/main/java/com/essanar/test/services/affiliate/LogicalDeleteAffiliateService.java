package com.essanar.test.services.affiliate;

import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.repository.AffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicalDeleteAffiliateService {

    private final AffiliateRepository affiliateRepository;

    @Autowired
    public LogicalDeleteAffiliateService(AffiliateRepository affiliateRepository){
        this.affiliateRepository = affiliateRepository;
    }

    /**
     * Cambia el estado de un afiliado a "deleted" para ocultarlo en el frontend.
     *
     * @param id El ID del afiliado que se va a "borrar" lógicamente.
     * @return El afiliado con el estado actualizado.
     */
    public String logicalDeleteAffiliate(Long id) {
        Affiliate affiliate = affiliateRepository.findById(id).orElse(null);
        if (affiliate != null) {
            affiliate.setStatus("deleted");
            return "Eliminado correctamente";
        }else {
            System.out.println("No se encontró el afiliado con el ID: " + id);
            return null;
        }
    }
}
