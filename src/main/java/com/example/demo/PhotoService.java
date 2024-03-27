package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class PhotoService {

    private final FileSystem fileSystem;

    @Autowired
    public PhotoService(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public Optional<byte[]> download(final String name) throws IOException {
        return Optional.of(fileSystem.load(name + ".jpg"));
    }


}
