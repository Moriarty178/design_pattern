package structural_pattern.proxy_pattern.service;

import structural_pattern.proxy_pattern.serviceinterface.Document;

public class RealDocument implements Document {
    private final String content;

    public RealDocument(String path) {
        this.content = "PDF content From: " + path;
        System.out.println("[RealDocument] Loaded from disk: " + path);
    }

    @Override
    public String read() {
        return content;
    }
}
