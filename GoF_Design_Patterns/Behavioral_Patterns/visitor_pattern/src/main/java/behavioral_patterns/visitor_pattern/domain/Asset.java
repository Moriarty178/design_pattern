package behavioral_patterns.visitor_pattern.domain;

import behavioral_patterns.visitor_pattern.visitor.AssetVisitor;

public interface Asset {
    void accept(AssetVisitor visitor);
}
