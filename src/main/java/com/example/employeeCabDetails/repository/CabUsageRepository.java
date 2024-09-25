package com.example.employeeCabDetails.repository;

import com.example.employeeCabDetails.entity.CabUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface CabUsageRepository extends JpaRepository<CabUsage, Long> {

    List<CabUsage> findByEmployeeNameAndCabDateBetween(String employeeName, LocalDate startDate, LocalDate endDate);

}