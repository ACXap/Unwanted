package Data;

import RepositoryUnwanted.Data.UnwontedLegal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EntityUnwonted {
    public static String SEPARATOR = ";";

    public EntityUnwonted(RepositoryUnwanted.Data.UnwontedLegal legal){
        NumberDoc = legal.NumberDoc;
        DateDoc = legal.DateDoc;

        AllName = GetAllName(legal);
    }

    public static List<EntityUnwonted> ConvertUnwantedLegal(List<UnwontedLegal> collection){
        return collection.stream().map(EntityUnwonted::new).collect(Collectors.toList());
    }

    private String GetAllName(RepositoryUnwanted.Data.UnwontedLegal legal) {
        List<String> names = new ArrayList<>();

        if(legal.Name!=null && !legal.Name.isEmpty()){
            names.add(legal.Name);
        }

        if(legal.Names!=null && legal.Names.size()>0){
            names.addAll(legal.Names);
        }

        if (names.size() > 0) return names.stream().distinct().collect(Collectors.joining(SEPARATOR));
        return null;
    }

    public String AllName;
    public String NumberDoc;
    public Date DateDoc;
}
