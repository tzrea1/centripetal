package com.joyboys.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.joyboys.admin", "com.joyboys.framework",
    "com.joyboys.common", "com.joyboys.system"}, exclude = {DataSourceAutoConfiguration.class})
public class CentripetalAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(CentripetalAdminApplication.class, args);
  }

}
