import java.util.ArrayList;
import java.util.List;

public class Owner {
    private static List<String> names;
    private String name;

    public Owner(String name)
    {
        if(Owner.names == null) names = new ArrayList<>();
        if(!Owner.names.contains(name)) {
            Owner.names.add(name);
        }
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public String toString()
    {
        return this.getName();
    }
}
