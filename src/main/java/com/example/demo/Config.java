package com.example.demo;

import com.example.testone.One;
import com.example.testtwo.Two;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootConfiguration
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackageClasses = {One.class, Two.class, Config.class})
public class Config {
}
