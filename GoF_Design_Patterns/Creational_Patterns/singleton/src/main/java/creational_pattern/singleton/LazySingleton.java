package creational_pattern.singleton;

public class LazySingleton {
    // private constructor default: đảm bảo client ko tạo được nhiều instance
    private LazySingleton() {}

    private static LazySingleton instance = null; // biến tĩnh lưu instance được tạo bởi hàm static dưới

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) { // Triển khai nâng cao: Lazy + Thread-safe (Double-Checked Locking)
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
