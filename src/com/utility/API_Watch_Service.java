package com.utility;

import java.io.IOException;
import java.nio.file.*;

public class API_Watch_Service {
    public static void main(String[] args) throws IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path directory = Paths.get("C:\\Automation\\EnnymaxQA\\ScreenShot\\");

        WatchKey watchKey = directory.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.kind());
                Path file = directory.resolve((Path) event.context());
                System.out.println(file + " was last modified at " + file.toFile().lastModified());
            }
        }
    }
}