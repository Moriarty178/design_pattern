package creational_pattern.singleton;

import org.apache.logging.log4j.util.Lazy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonApplication.class, args);

		LazySingleton singleton1 = LazySingleton.getInstance();
		LazySingleton singleton2 = LazySingleton.getInstance();

		System.out.println("Singleton1: " + singleton1);
		System.out.println("Singleton2: " + singleton2);
	}

}
