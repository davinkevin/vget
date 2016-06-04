package com.github.axet.vget;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppManagedWithBuilder {

    private void run(String url, File path) {

        AtomicBoolean stop = new AtomicBoolean();

        VGet vget = VGet.from(url)
                    .with(new CustomNotifier())
                    .inDir(path)
                    .stopOn(stop)
                .download();
    }

    public static void main(String[] args) {
        AppManagedWithBuilder e = new AppManagedWithBuilder();
        e.run("https://www.youtube.com/watch?v=fBXJrAa-YWE", new File("/tmp/"));
    }
}