package gof.patterns.adapter_pattern;

import gof.patterns.adapter_pattern.controler.PaymentController;
import gof.patterns.adapter_pattern.model.PaymentRequest;
import gof.patterns.adapter_pattern.model.PaymentResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Objects;

@SpringBootApplication
public class AdapterPatternApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AdapterPatternApplication.class, args);
//		PaymentController controller = context.getBean(PaymentController.class);
//
//		PaymentRequest request = new PaymentRequest("799", 1123.0, "dollar");
//		ResponseEntity<?> response = controller.makePayment(request);
//		Map<String, Object> result = (Map<String, Object>) response.getBody();
//		PaymentResult paymentResult =  null;
//		if (result.get("data") != null && result.get("data") instanceof PaymentResult) {
//			paymentResult = (PaymentResult) result.get("data");
//		}
//		System.out.println("result: " +  result);
	}

}
