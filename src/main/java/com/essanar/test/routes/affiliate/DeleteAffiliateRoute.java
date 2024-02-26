package com.essanar.test.routes.affiliate;

import com.essanar.test.dtos.UpdateAffiliateDto;
import com.essanar.test.entities.affiliate.Affiliate;
import com.essanar.test.services.affiliate.DeleteAffiliateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/affiliates/{id}")
public class DeleteAffiliateRoute {
    private final DeleteAffiliateService deleteAffiliateService;

    public DeleteAffiliateRoute(DeleteAffiliateService deleteAffiliateService){
        this.deleteAffiliateService = deleteAffiliateService;
    }

    @DeleteMapping(headers = "Accept=application/json")
    public ResponseEntity<String> deleteAffiliateRoute(@PathVariable("id") Long id) {
        try {
            deleteAffiliateService.deleteAffiliate(id);
            return new ResponseEntity<>("Afiliado eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
