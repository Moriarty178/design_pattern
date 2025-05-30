package behavioral_patterns.visitor_pattern.controller;

import behavioral_patterns.visitor_pattern.domain.Building;
import behavioral_patterns.visitor_pattern.domain.Computer;
import behavioral_patterns.visitor_pattern.domain.Vehicle;
import behavioral_patterns.visitor_pattern.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/asset")
public class AssetController {

    @Autowired
    private AssetService service;

    @GetMapping("/audit")
    public String audit() {
        var assets = Arrays.asList(
                new Vehicle("Ford Ranger", 2020),
                new Building("123 Nguyen Trai", 300),
                new Computer("PC-115", "Windows")
        );
        service.auditAssets(assets);
        return "Audit completed.";
    }

    @GetMapping("/value")
    public String valuation() {
        var assets = Arrays.asList(
                new Vehicle("Tesla", 2021),
                new Building("456 My Dinh Tower", 500),
                new Computer("PC-119", "Linux")
        );
        service.valuateAssets(assets);
        return "Valuation completed.";
    }

    @GetMapping("/export")
    public String exporting() {
        var assets = Arrays.asList(
                new Vehicle("Toyota", 2024),
                new Building("Trump Tower", 789),
                new Computer("PC-119", "MacOs")
        );
        service.exportAssets(assets);
        return "Export completed.";
    }
}
