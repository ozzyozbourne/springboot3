package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@ShellComponent
public class PhotoCommands {

    private final PhotoService photoService;

    @Autowired
    public PhotoCommands(PhotoService photoService) {
        this.photoService = photoService;
    }

    @ShellMethod("Show Photo")
    public String showPhoto(final String name) throws IOException {
        return photoService.download(name).map(bytes -> {
            try {
                final BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
                return String.format("Width: %d, Height: %d", image.getWidth(), image.getHeight());
            }catch (IOException e){
                return "Unable to read the dimensions";
            }
        }).orElse("Image not found");
    }
}
