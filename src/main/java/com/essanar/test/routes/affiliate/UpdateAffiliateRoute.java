package com.essanar.test.routes.affiliate;

import com.essanar.test.dtos.UpdateAffiliateDto;
import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.services.affiliate.UpdateAffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/affiliates/{id}")
public class UpdateAffiliateRoute {
    private final UpdateAffiliateService updateAffiliateService;

    @Autowired
    public UpdateAffiliateRoute(UpdateAffiliateService updateAffiliateService){
        this.updateAffiliateService = updateAffiliateService;
    }

    @PutMapping(headers = "Accept=application/json")
    public ResponseEntity<Affiliate> updateAffiliateRoute(@PathVariable("id") Long id, @RequestBody UpdateAffiliateDto updateAffiliateDto) {
        try {
            Affiliate updatedAffiliate = updateAffiliateService.updateAffiliate(id, updateAffiliateDto);
            return new ResponseEntity<>(updatedAffiliate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
