package RepositoryUnwanted.Data;

import org.apache.commons.collections.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UnwantedLegal {
    private static final String SPLIT_FIELDS_CHAR = ";" ;

    public UnwantedLegal(String content) throws ParseException {
        String[] filds = content.split(SPLIT_FIELDS_CHAR);
        String[] nd = filds[1].split(" ");

        NumberDoc = nd[1];
        DateDoc = new SimpleDateFormat("dd.MM.yyyy").parse(nd[3]);

        String[] names = filds[3].split("\\(");
        Name = RemoveBadSymbol(names[0]);

        if (names.length > 1) {
            for (int i = 1; i < names.length; i++) {
                Names.add(RemoveBadSymbol(names[i]));
            }
        }
    }

    public String Name;
    public List<String> Names = new ArrayList<>();
    public String NumberDoc;
    public Date DateDoc;

    private String RemoveBadSymbol(String content){
       return content.replace(")", "").replace("\"", "").replace("«", "").replace("»", "").trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnwantedLegal that = (UnwantedLegal) o;

        boolean isEquals = Name.equals(that.Name) && NumberDoc.equals(that.NumberDoc) && DateDoc.equals(that.DateDoc);

        if(isEquals){
            isEquals = CollectionUtils.isEqualCollection(Names, that.Names);
        }

        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Names, NumberDoc, DateDoc);
    }
}
