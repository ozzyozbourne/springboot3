package com.example.demo;

import com.example.testone.One;
import com.example.testone.Three;
import com.example.testtwo.Two;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
        basePackageClasses = {One.class, Two.class, Config.class},
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {FileSystem.class, Three.class, Two.class}
        ))
public class Config {}
