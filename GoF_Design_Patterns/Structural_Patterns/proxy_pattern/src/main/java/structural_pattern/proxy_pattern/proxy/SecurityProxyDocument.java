package structural_pattern.proxy_pattern.proxy;

import structural_pattern.proxy_pattern.serviceinterface.Document;

public class SecurityProxyDocument implements Document {
    private final Document innerDocument; //có một trường tham chiếu đén 1 đối tượng Service  để có thể sử dụng Service”vì cùng ServiceInterface” bất kỳ nơi nào Service mong đợi.
    private final String role;

    public SecurityProxyDocument(Document innerDocument, String role) {
        this.innerDocument = innerDocument;
        this.role = role;
    }

    @Override
    public String read() {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            return "[Security] Access Denied: Only ADMINs allowed.";
        }
        return innerDocument.read();
    }
}
