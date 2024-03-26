package com.example.demo;

import com.example.testone.One;
import com.example.testone.Three;
import com.example.testtwo.Two;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
public class DemoApplication {

    public static void main(final String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Config.class, args);
        final FileSystem fileSystem =  context.getBean(FileSystem.class);
        System.out.println(DataSize.ofBytes(fileSystem.getFreeSpace()).toGigabytes() + " GB");
        final Three three = context.getBean(Three.class);
        final One one = context.getBean(One.class);
        final Two two = context.getBean(Two.class);
        System.out.println(one + " " + two + " " + three);
    }

}
