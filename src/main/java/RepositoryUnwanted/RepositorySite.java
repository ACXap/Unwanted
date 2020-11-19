package RepositoryUnwanted;

import Interfaces.IHttpService;
import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwontedResponse;

public class RepositorySite implements IRepositoryUnwanted {

    public RepositorySite(IHttpService httpService) {
        _http = httpService;
    }

    private final IHttpService _http;


    @Override
    public UnwontedResponse GetResponse() throws Exception {
        return null;
    }
}