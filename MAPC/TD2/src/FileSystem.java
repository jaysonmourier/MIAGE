// Component
public interface FileSystem<T> {
    String getName();
    T getContent();
    Owner getOwner();
    int getSize();
    void appendContent(T content);
    void setOwner(Owner o);
}
