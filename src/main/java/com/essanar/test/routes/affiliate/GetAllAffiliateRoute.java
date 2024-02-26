package com.essanar.test.routes.affiliate;

import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.services.affiliate.CreateAffiliateService;
import com.essanar.test.services.affiliate.GetAllAffiliatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/affiliates")
public class GetAllAffiliateRoute {
    private final GetAllAffiliatesService getAllAffiliatesService;

    @Autowired
    public GetAllAffiliateRoute(GetAllAffiliatesService getAllAffiliatesService) {
        this.getAllAffiliatesService = getAllAffiliatesService;
    }

    @GetMapping(headers = "Accept=application/json")
    public ResponseEntity<List<Affiliate>> getAllAffiliateRoute() {
        try {
            List<Affiliate> affiliates = getAllAffiliatesService.getAllAffiliates();
            return new ResponseEntity<>(affiliates, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
