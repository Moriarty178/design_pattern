package behavioral_patterns.visitor_pattern.service;

import behavioral_patterns.visitor_pattern.domain.Asset;
import behavioral_patterns.visitor_pattern.visitor.AuditVisitor;
import behavioral_patterns.visitor_pattern.visitor.ExportVisitor;
import behavioral_patterns.visitor_pattern.visitor.ValuationVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AuditVisitor auditVisitor;

    @Autowired
    private ValuationVisitor valuationVisitor;

    @Autowired
    private ExportVisitor exportVisitor;

    public void auditAssets(List<Asset> assets) {
        assets.forEach(asset -> asset.accept(auditVisitor));
    }

    public void valuateAssets(List<Asset> assets) {
        assets.forEach(asset -> asset.accept(valuationVisitor));
    }

    public void exportAssets(List<Asset> assets) {
        assets.forEach(asset -> asset.accept(exportVisitor));
    }
}
