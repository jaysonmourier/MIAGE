public class File<T> extends FileSystemAbstract<T> {
    T content;

    @Override
    public T getContent() {
        return this.content;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void appendContent(T content) {

    }
}
