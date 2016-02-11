package com.github.asieira.vfs2_xz;

import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.provider.AbstractFileName;
import org.apache.commons.vfs2.provider.compressed.CompressedFileFileSystem;

import java.util.Collection;

/**
 * Created by asieira on 10/02/16.
 */
public class XzFileSystem extends CompressedFileFileSystem {
    protected XzFileSystem(final FileName rootName, final FileObject parentLayer,
                           final FileSystemOptions fileSystemOptions)
    {
        super(rootName, parentLayer, fileSystemOptions);
    }

    @Override
    protected void addCapabilities(Collection<Capability> caps) {
        caps.addAll(XzFileProvider.capabilities);
    }

    @Override
    protected FileObject createFile(AbstractFileName name) throws FileSystemException {
        return new XzFileObject(name, getParentLayer(), this);
    }
}
