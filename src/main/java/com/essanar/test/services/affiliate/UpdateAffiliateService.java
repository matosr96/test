package com.essanar.test.services.affiliate;

import com.essanar.test.dtos.UpdateAffiliateDto;
import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.repository.AffiliateRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UpdateAffiliateService {
    private final AffiliateRepository affiliateRepository;

    @Autowired
    public UpdateAffiliateService(AffiliateRepository affiliateRepository){
        this.affiliateRepository = affiliateRepository;
    }

    /**
     * Actualiza un afiliado existente con los datos proporcionados en el DTO.
     * La idea es permitir actualizaciones parciales desde el frontend para
     * optimizar las peticiones y hacerlas más rápidas.
     *
     * @param id        El ID del afiliado que se va a actualizar.
     * @param updateDto DTO que contiene los datos que se van a actualizar.
     * @return El afiliado actualizado.
     */
    public Affiliate updateAffiliate(Long id, UpdateAffiliateDto updateDto) {
        Affiliate existingAffiliate = affiliateRepository.findById(id).orElse(null);

        if (existingAffiliate != null) {
            BeanUtils.copyProperties(updateDto, existingAffiliate, getNullPropertyNames(updateDto));
            return affiliateRepository.save(existingAffiliate);
        }
        return null;
    }

    /**
     * Obtiene los nombres de las propiedades nulas de un objeto.
     * Se utiliza para identificar los campos no proporcionados en el DTO
     * y evitar sobrescribir valores existentes con null.
     *
     * @param source Objeto del cual se obtienen los nombres de las propiedades nulas.
     * @return Array de strings con los nombres de las propiedades nulas.
     */
    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
