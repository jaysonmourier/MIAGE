// Component
public interface FileSystem {
    String getName();
    FileSystem getContent();
    Owner getOwner();
    int getSize();
    void appendContent(FileSystem content);
    void setOwner(Owner o);
}
