package creational_patterns.prototype_pattern.prototype;

import creational_patterns.prototype_pattern.model.Contract;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ContractPrototypeRegistry {
    private static final Map<String, Contract> registry = new HashMap<>();

    static {
        // Add template
        Contract template = new Contract("{{customer}}", "Standard Contract Terms...", new Date());
        registry.put("standard", template);
    }

    public static Contract getTemplate(String type) {
        Contract template = registry.get(type);
        return template != null ? template.clone() : null;
    }
}
