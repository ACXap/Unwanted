package Interfaces;

import RepositoryUnwanted.Data.UnwantedResponse;

public interface IRepositoryUnwanted {
    UnwantedResponse GetResponse() throws Exception;
}