package com.essanar.test.repository;

import com.essanar.test.entities.affiliate.Affiliate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AffiliateRepository extends JpaRepository<Affiliate, Long> {
    @Query("SELECT a FROM Affiliate a WHERE a.status = 'active'")
    List<Affiliate> findAllActiveAffiliates();
}
