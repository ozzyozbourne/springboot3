package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

@ShellComponent
public class FsCommands {

    private final FileSystem fileSystem;

    @Autowired
    public FsCommands(final FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }


    @ShellMethod("Display free space")
    public String minimumFreeDiskSpace(){
        return DataSize.ofBytes(fileSystem.getFreeSpace()).toGigabytes() + " GB";
    }

    @ShellMethod("Convert to lowercase string")
    public String toLowerCase(String s){
        return s.toLowerCase();
    }

}
