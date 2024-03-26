package com.example.demo;

import com.example.testone.One;
import com.example.testtwo.Two;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.unit.DataSize;

public final class DemoApplication {

    public static void main(final String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Config.class, args);
        final FileSystem fileSystem =  context.getBean(FileSystem.class);
        System.out.println(DataSize.ofBytes(fileSystem.getFreeSpace()).toGigabytes() + " GB");
        final One one = context.getBean(One.class);
        final Two two = context.getBean(Two.class);
        System.out.println(one + " " + two);
    }

}
