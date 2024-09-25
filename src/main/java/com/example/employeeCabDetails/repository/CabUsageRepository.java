package com.example.employeeCabDetails.repository;

import com.example.employeeCabDetails.entity.CabUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface CabUsageRepository extends JpaRepository<CabUsage, Long> {


    @Query("SELECT DISTINCT c FROM CabUsage c WHERE c.employeeName = ?1 AND c.cabDate BETWEEN ?2 AND ?3")
    List<CabUsage> findUniqueCabUsageByEmployeeNameAndCabDateBetween(String employeeName, LocalDate startDate, LocalDate endDate);

        List<CabUsage> findByEmployeeNameAndCabDateBetween(String employeeName, LocalDate startDate, LocalDate endDate);

      default List<CabUsage> findUniqueByEmployeeNameAndCabDateBetween(String employeeName, LocalDate startDate, LocalDate endDate) {
            return findByEmployeeNameAndCabDateBetween(employeeName, startDate, endDate)
                    .stream()
                    .distinct() // Ensures unique values based on the equals method in CabUsage
                    .collect(Collectors.toList());

    }

}