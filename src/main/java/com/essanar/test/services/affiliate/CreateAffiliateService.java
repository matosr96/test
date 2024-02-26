package com.essanar.test.services.affiliate;

import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.repository.AffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAffiliateService {

    private final AffiliateRepository affiliateRepository;

    @Autowired
    public CreateAffiliateService(AffiliateRepository affiliateRepository){
        this.affiliateRepository = affiliateRepository;
    }

    /**
     * Crea un nuevo afiliado con el estado por defecto "active".
     * Este método permite dos tipos de "borrados" desde el frontend:
     *   1. Cambiar el estado a "delete": El afiliado no se mostrará en el frontend,
     *      ya que el en listar se aplicara el filtro por status "active",
     *      pero permanecerá en la base de datos para proteger la información.
     *   2. Borrado físico de la base de datos: Elimina completamente el afiliado.
     *
     * @param affiliate El afiliado que se va a crear.
     * @return El afiliado creado.
     */
    public Affiliate createAffiliate(Affiliate affiliate){
        affiliate.setStatus("active");
       return affiliateRepository.save(affiliate);
    }
}
