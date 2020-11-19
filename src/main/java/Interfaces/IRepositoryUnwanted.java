package Interfaces;

import RepositoryUnwanted.Data.UnwontedResponse;

import java.io.IOException;

public interface IRepositoryUnwanted {
    UnwontedResponse GetResponse() throws Exception;
}