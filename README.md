[![Build Status](https://travis-ci.org/asieira/vfs2-xz.svg?branch=master)](https://travis-ci.org/asieira/vfs2-xz)

# vfs2-xz

[Apache Commons VFS](https://commons.apache.org/proper/commons-vfs/) support for XZ files based on their internal 
implementations for bzip2 and gzip and [XZ for Java](http://tukaani.org/xz/java.html).

Simply drop the JAR file into your CLASSPATH and you should be able to open URIs like `xz:/path/to/file.xz` for reading
and writing.
