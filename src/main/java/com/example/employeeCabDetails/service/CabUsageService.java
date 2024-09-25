package com.example.employeeCabDetails.service;

import com.example.employeeCabDetails.entity.CabUsage;
import com.example.employeeCabDetails.repository.CabUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class CabUsageService {

    @Autowired
    private CabUsageRepository repository;

    public void saveCabUsage(CabUsage cabUsage) {
        repository.save(cabUsage);
    }

    public List<CabUsage> getEmployeeCabUsageForMonth(String employeeName, LocalDate startDate, LocalDate endDate) {
        return repository.findByEmployeeNameAndCabDateBetween(employeeName, startDate, endDate);
    }
}

