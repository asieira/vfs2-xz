package com.github.asieira.vfs2_xz;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.provider.AbstractFileName;
import org.apache.commons.vfs2.provider.compressed.CompressedFileFileObject;
import org.apache.commons.vfs2.provider.compressed.CompressedFileFileSystem;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZInputStream;
import org.tukaani.xz.XZOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by asieira on 10/02/16.
 */
public class XzFileObject extends CompressedFileFileObject {
    protected XzFileObject(AbstractFileName name, FileObject container,
                           CompressedFileFileSystem fs) {
        super(name, container, fs);
    }

    @Override
    protected InputStream doGetInputStream() throws Exception {
        final InputStream is = getContainer().getContent().getInputStream();
        return new XZInputStream(is);
    }

    @Override
    protected OutputStream doGetOutputStream(final boolean bAppend) throws Exception {
        final OutputStream os = getContainer().getContent().getOutputStream(false);
        return new XZOutputStream(os, new LZMA2Options());
    }
}
