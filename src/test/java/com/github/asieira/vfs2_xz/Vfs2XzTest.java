package com.github.asieira.vfs2_xz;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by asieira on 11/02/16.
 */
public class Vfs2XzTest {
    @Test
    public void test() throws IOException {
        File tmpfile = File.createTempFile("VfsXzTest", ".xz");
        tmpfile.delete();
        String testData = "This is a simple, simple test!";

        FileSystemManager fsManager = VFS.getManager();

        // write test data to file
        FileObject file = fsManager.resolveFile("xz:" + tmpfile.getAbsolutePath());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(file.getContent().getOutputStream()));
        writer.write(testData);
        writer.close();
        file.close();

        // read and compare
        file = fsManager.resolveFile("xz:" + tmpfile.getAbsolutePath());
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContent().getInputStream()));
        assertEquals(reader.readLine(), testData);
    }
}
