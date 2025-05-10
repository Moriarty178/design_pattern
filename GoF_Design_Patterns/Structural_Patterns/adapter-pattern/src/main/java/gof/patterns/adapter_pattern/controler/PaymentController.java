package gof.patterns.adapter_pattern.controler;

import gof.patterns.adapter_pattern.adapter.PaymentAdapter;
import gof.patterns.adapter_pattern.client.StripeApiClient;
import gof.patterns.adapter_pattern.domain.PaymentService;
import gof.patterns.adapter_pattern.model.PaymentRequest;
import gof.patterns.adapter_pattern.model.PaymentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    //private final PaymentService paymentService = new PaymentAdapter(new StripeApiClient()); // initial thủ công: ko dùng DDependency Injection <ko cần các bean trong application context: StripApiClient, PaymentAdapter>.
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {// paymentService <--DI-- paymentAdapter [phải trong context] <--DI-- stripApiClient [phải trong context] --
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<?> makePayment(@RequestBody PaymentRequest request) {
        PaymentResult result = paymentService.processPayment(request);

        return ResponseEntity.ok(Map.of(
                "EC", 0,
                "MS", "success",
                "data", result
        ));
    }
}
