package structural_pattern.proxy_pattern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import structural_pattern.proxy_pattern.proxy.CachingProxyDocument;
import structural_pattern.proxy_pattern.proxy.LoggingProxyDocument;
import structural_pattern.proxy_pattern.proxy.SecurityProxyDocument;
import structural_pattern.proxy_pattern.service.RealDocument;
import structural_pattern.proxy_pattern.serviceinterface.Document;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    @GetMapping("/read")
    public String readDoc(@RequestParam String path, @RequestParam String role) {
        Document realDoc = new RealDocument(path);

        Document doc = new LoggingProxyDocument(
                        new CachingProxyDocument(
                          new SecurityProxyDocument(realDoc, role)
                        ));
        return doc.read();
    }
}
