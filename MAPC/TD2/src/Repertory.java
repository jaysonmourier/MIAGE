// Composite

import java.util.List;

public class Repertory extends FileSystemAbstract {
    List<FileSystem> files;

    Repertory(String name, Owner o) {
        super(name, o);
    }

    @Override
    public FileSystem getContent() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void appendContent(FileSystem content) {

    }
}
