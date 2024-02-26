package com.essanar.test.routes.affiliate;

import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.services.affiliate.GetAffiliateByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/affiliates/get-by-id/{id}")
public class getAffiliateByIdRoute {

    private final GetAffiliateByIdService getAffiliateByIdService;

    public getAffiliateByIdRoute(GetAffiliateByIdService getAffiliateByIdService){
        this.getAffiliateByIdService = getAffiliateByIdService;
    }

    @GetMapping(headers = "Accept=application/json")
    public ResponseEntity<Object> getAffiliateByIdRoute(@PathVariable("id") Long id) {
        try {
            Object affiliates = getAffiliateByIdService.getAffiliateById(id);
            return new ResponseEntity<>(affiliates, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
