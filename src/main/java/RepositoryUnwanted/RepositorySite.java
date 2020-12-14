package RepositoryUnwanted;

import Interfaces.IHttpService;
import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwantedResponse;

public class RepositorySite implements IRepositoryUnwanted {

    public RepositorySite(IHttpService httpService) {
        _http = httpService;
    }

    private final IHttpService _http;


    @Override
    public UnwantedResponse GetResponse() throws Exception {

        String result = _http.RequestGet();

        return null;
    }
}