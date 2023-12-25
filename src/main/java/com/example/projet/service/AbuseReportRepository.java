package com.example.projet.service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbuseReportRepository extends CrudRepository<AbuseReport, Long> {
    // ممکن است متدهای خاص به این Repository اضافه شود
}
