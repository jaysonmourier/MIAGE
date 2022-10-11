// Composite

import java.util.List;

public class Repertory<T> extends FileSystemAbstract<T> {
    List<FileSystem> files;

    @Override
    public T getContent() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void appendContent(T content) {

    }
}
