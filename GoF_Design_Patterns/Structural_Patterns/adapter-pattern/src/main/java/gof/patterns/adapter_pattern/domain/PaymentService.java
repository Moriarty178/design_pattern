package gof.patterns.adapter_pattern.domain;

import gof.patterns.adapter_pattern.model.PaymentRequest;
import gof.patterns.adapter_pattern.model.PaymentResult;
import org.springframework.stereotype.Component;

@Component
public interface PaymentService { // interface mới <chuẩn>
    PaymentResult processPayment(PaymentRequest request); // đang cần xử lý theo interface mới (param nhận, output return...) trong khi logic bên trong sử dụng "legacy" StripeApiClient
}
