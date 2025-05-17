package structural_pattern.proxy_pattern.proxy;

import structural_pattern.proxy_pattern.serviceinterface.Document;

public class LoggingProxyDocument implements Document {
    private final Document innerDocument;

    public LoggingProxyDocument(Document innerDocument) {
        this.innerDocument = innerDocument;
    }

    @Override
    public String read() {
        System.out.println("[Log] Document read at " + java.time.LocalDateTime.now());
        return innerDocument.read();
    }
}
