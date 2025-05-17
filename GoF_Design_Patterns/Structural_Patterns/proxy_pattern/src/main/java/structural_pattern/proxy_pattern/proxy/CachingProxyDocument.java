package structural_pattern.proxy_pattern.proxy;

import structural_pattern.proxy_pattern.serviceinterface.Document;

public class CachingProxyDocument implements Document {
    private final Document innerDocument;
    private String cachedContent;

    public CachingProxyDocument(Document innerDocument) {
        this.innerDocument = innerDocument;
    }

    @Override
    public String read() {
        if (cachedContent == null) {
            System.out.println("[Cache] Miss. Reading from inner document.");
            cachedContent = innerDocument.read();
        } else {
            System.out.println("[Cached] Hit. Returning cached content.");
        }
        return cachedContent;
    }
}
