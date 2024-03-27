package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public final class  FileSystem {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Path root = Paths.get(System.getProperty("user.home"))
            .resolve("fs")
            .toAbsolutePath()
            .normalize();

    public FileSystem(){
        if(!Files.isDirectory(root)){
            try{
                Files.createDirectory(root);
            }catch (IOException e){
                log.error("{}", e.getMessage(), e);
            }
        }
    }

    public long getFreeSpace(){
        return root.toFile().getFreeSpace();
    }

    public byte[] load(final String filename) throws IOException {
        return Files.readAllBytes(resolve(filename));
    }

    private Path resolve(final String filename) throws SecurityException{
        final Path path = root.resolve(filename).toAbsolutePath().normalize();
        if(!path.startsWith(root)) throw new SecurityException(String.format("ACCESS TO %s DENIED", path));
        return path;
    }

    public void store(final String filename, final byte[] bytes) throws IOException {
        Files.write(resolve(filename), bytes);
    }
}
