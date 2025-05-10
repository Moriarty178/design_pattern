package gof.patterns.adapter_pattern.adapter;

import gof.patterns.adapter_pattern.client.StripeApiClient;
import gof.patterns.adapter_pattern.domain.PaymentService;
import gof.patterns.adapter_pattern.model.PaymentRequest;
import gof.patterns.adapter_pattern.model.PaymentResult;
import gof.patterns.adapter_pattern.model.StripeResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapter implements PaymentService {
    // bọc "legacy"
    private final StripeApiClient stripeApiClient;

    public PaymentAdapter(StripeApiClient stripeApiClient) {
        this.stripeApiClient = stripeApiClient;
    }

    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        // sử dụng legacy cho phần xử lý (với input là chuẩn mới)
        StripeResponse response = stripeApiClient.makeStripePayment(request.getUserId(), request.getAmount(), request.getCurrency());

        //nv chính adapter: chuyển đổi để tương thích giữa cũ và mới
        return new PaymentResult(
                "SUCCESS".equals(response.getStatus()),
                "txn_" + response.getUserId(),
                response.getMessage(),
                String.valueOf(response.getAmount()) + ("dollar".equals(response.getCurrency()) ? "$" : "")
        );
    }
}
