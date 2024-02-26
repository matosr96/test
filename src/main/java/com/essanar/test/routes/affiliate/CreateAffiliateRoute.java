package com.essanar.test.routes.affiliate;

import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.services.affiliate.CreateAffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/affiliates")
@CrossOrigin(origins = "*", maxAge = 3600 )
public class CreateAffiliateRoute {

    private final CreateAffiliateService createAffiliateService;

    @Autowired
    public CreateAffiliateRoute(CreateAffiliateService createAffiliateService) {
        this.createAffiliateService = createAffiliateService;
    }

    @PostMapping(headers = "Accept=application/json")
    public ResponseEntity<String> createAffiliateRoute(@RequestBody Affiliate affiliate) {
        try {
            createAffiliateService.createAffiliate(affiliate);
            return new ResponseEntity<>("Afiliado creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el afiliado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}