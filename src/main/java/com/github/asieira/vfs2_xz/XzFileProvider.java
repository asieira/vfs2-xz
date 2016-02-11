package com.github.asieira.vfs2_xz;

import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.provider.compressed.CompressedFileFileProvider;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by asieira on 10/02/16.
 */
public class XzFileProvider extends CompressedFileFileProvider {
    protected static final Collection<Capability> capabilities =
            Collections.unmodifiableCollection(Arrays.asList(Capability.GET_LAST_MODIFIED, Capability.GET_TYPE,
                    Capability.LIST_CHILDREN, Capability.WRITE_CONTENT, Capability.READ_CONTENT, Capability.URI,
                    Capability.COMPRESS));

    public XzFileProvider() {
        super();
    }

    @Override
    protected FileSystem createFileSystem(FileName name, FileObject file, FileSystemOptions fileSystemOptions)
            throws FileSystemException {
        return new XzFileSystem(name, file, fileSystemOptions);
    }

    @Override
    public Collection<Capability> getCapabilities() {
        return capabilities;
    }
}
