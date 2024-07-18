package com.myprojects.mypokeapi.service;

import com.myprojects.mypokeapi.entity.Region;
import com.myprojects.mypokeapi.repository.RegionRepository;
import com.myprojects.mypokeapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found"));
    }

    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }
}
