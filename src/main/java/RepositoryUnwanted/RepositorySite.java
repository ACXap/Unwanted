package RepositoryUnwanted;

import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwantedLegal;
import RepositoryUnwanted.Data.UnwantedResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorySite implements IRepositoryUnwanted {

    public RepositorySite(String url){
        _url = url;
    }

    private final String _url;

    @Override
    public UnwantedResponse GetResponse() throws Exception {

        UnwantedResponse response = new UnwantedResponse();

        Document doc = Jsoup.connect(_url).get();
        Element tbody = doc.getElementsByTag("tbody").get(0);
        List<Element> listTr = tbody.getElementsByTag("tr");

        for(Element e : listTr){
            List<Element> td = e.children();

            UnwantedLegal legal = new UnwantedLegal(td.stream().map(Element::text).collect(Collectors.joining(";")));
            response.UnwantedLegals.add(legal);
        }

        return response;
    }
}