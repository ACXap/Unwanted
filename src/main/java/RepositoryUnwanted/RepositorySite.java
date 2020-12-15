package RepositoryUnwanted;

import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwantedLegal;
import RepositoryUnwanted.Data.UnwantedResponse;
import Service.PropertyService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.Proxy;
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

        Document doc = Jsoup.connect(_url).proxy(PropertyService.InternetConnectProperty.ProxyServer, PropertyService.InternetConnectProperty.ProxyPort).get();

        for(Element e : doc.getElementsByTag("tbody").get(0).getElementsByTag("tr")){
            List<Element> td = e.children();

            UnwantedLegal legal = new UnwantedLegal(td.stream().map(Element::text).collect(Collectors.joining(";")));
            response.UnwantedLegals.add(legal);
        }

        return response;
    }
}