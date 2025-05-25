package structural_pattern.facade_pattern.service;

import org.springframework.stereotype.Service;

@Service
public class PushNotification {
    public void sendPush(String deviceId, String message) {
        System.out.println("Push Notification sent to device " + deviceId + ": " + message);
    }
}
