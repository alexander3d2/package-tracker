package com.example.packageTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PackageTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PackageTrackerApplication.class, args);
    }

    // Crear un bean CommandLineRunner para ejecutar la aplicación Swing
    @Bean
    public CommandLineRunner run(PackageTrackingService trackingService) {
        return args -> {
            // Crear e inicializar la aplicación Swing
            PackageTrackerApp app = new PackageTrackerApp(trackingService);
        };
    }
}
