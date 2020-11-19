package RepositoryUnwanted.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UnwantedLegal {

    public UnwantedLegal(String content) throws ParseException {
        String[] filds = content.split(";");
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
}
