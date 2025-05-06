package org.example;

import org.example.models.FileInfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadThread extends Thread {

    private final FileInfo file;
    private final DownloadManager manager;

    public DownloadThread(FileInfo file, DownloadManager manager) {
        this.file = file;
        this.manager = manager;
    }

    @Override
    public void run() {
        file.setStatus("DOWNLOADING");
        manager.updateUI(file);

        try (InputStream in = new URL(file.getUrl()).openStream()) {
            Files.copy(in, Paths.get(file.getPath()));
            file.setStatus("DONE");
        } catch (IOException e) {
            file.setStatus("FAILED");
            System.err.println("Error downloading file: " + file.getUrl());
            e.printStackTrace();
        }

        manager.updateUI(file);
    }
}