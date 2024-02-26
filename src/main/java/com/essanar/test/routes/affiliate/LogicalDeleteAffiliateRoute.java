package com.essanar.test.routes.affiliate;

import com.essanar.test.services.affiliate.LogicalDeleteAffiliateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/affiliates/deleted/{id}")
public class LogicalDeleteAffiliateRoute {
    private final LogicalDeleteAffiliateService logicalDeleteAffiliateService;

    public LogicalDeleteAffiliateRoute(LogicalDeleteAffiliateService logicalDeleteAffiliateService){
        this.logicalDeleteAffiliateService = logicalDeleteAffiliateService;
    }

    @PutMapping(headers = "Accept=application/json")
    public ResponseEntity<String> logicalDeleteRoute(@PathVariable("id") Long id) {
        try {
            logicalDeleteAffiliateService.logicalDeleteAffiliate(id);
            return new ResponseEntity<>("Afiliado eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
