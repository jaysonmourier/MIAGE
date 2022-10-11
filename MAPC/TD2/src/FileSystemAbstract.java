public abstract class FileSystemAbstract<T> implements FileSystem<T> {
    String name;
    Owner owner;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Owner getOwner() {
        return this.owner;
    }

    @Override
    public void setOwner(Owner o)
    {
        this.owner = o;
    }
}
