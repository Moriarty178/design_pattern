package creational_patterns.prototype_pattern.service;

import creational_patterns.prototype_pattern.model.Contract;
import creational_patterns.prototype_pattern.prototype.ContractPrototypeRegistry;

import java.util.Date;

public class ContractService {
    public Contract createContractFor(String customerName) {
        Contract contract = ContractPrototypeRegistry.getTemplate("standard");
        contract.setCustomerName(customerName);
        contract.setCreatedDate(new Date());
        return contract;
    }
}
