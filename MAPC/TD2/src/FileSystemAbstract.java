public abstract class FileSystemAbstract implements FileSystem {
    String name;
    Owner owner;

    FileSystemAbstract(String name, Owner o)
    {
        this.name = name;
        this.setOwner(o);
    }

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

    @Override
    public String toString()
    {
        return "Name's file: '" + this.name + "' (Owned by '" + this.owner + "').";
    }
}
