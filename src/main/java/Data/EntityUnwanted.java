package Data;

import RepositoryUnwanted.Data.UnwantedLegal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EntityUnwanted {
    public static String SEPARATOR = ";";

    public EntityUnwanted(UnwantedLegal legal){
        NumberDoc = legal.NumberDoc;
        DateDoc = legal.DateDoc;

        AllName = GetAllName(legal);
    }

    public static List<EntityUnwanted> ConvertUnwantedLegal(List<UnwantedLegal> collection){
        return collection.stream().map(EntityUnwanted::new).collect(Collectors.toList());
    }

    private String GetAllName(UnwantedLegal legal) {
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
