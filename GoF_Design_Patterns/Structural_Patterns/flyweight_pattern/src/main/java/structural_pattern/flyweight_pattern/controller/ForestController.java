package structural_pattern.flyweight_pattern.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import structural_pattern.flyweight_pattern.service.ForestService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/forest")
public class ForestController {

    private final ForestService forestService;

    public ForestController(ForestService forestService) {
        this.forestService = forestService;
    }

    @PostMapping("/plant")
    public ResponseEntity<?> plantTrees(@RequestParam(defaultValue = "999") int count) {
        forestService.plantRandomTrees(count);
        return ResponseEntity.ok(Map.of("MS", "Success", "Total trees planted", count));
    }

    @GetMapping("/draw")
    public String drawForest() {
        forestService.drawForest();
        return "Forest drawn.";
    }
}
