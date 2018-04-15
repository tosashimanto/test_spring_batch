package jp.co.test;

import jp.co.test.aaa.BatchConfiguration;
import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String [] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(
                BatchConfiguration.class, args)));
    }
}
