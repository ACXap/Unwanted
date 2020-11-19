package RepositoryUnwanted;

import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwontedLegal;
import RepositoryUnwanted.Data.UnwontedResponse;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RepositoryFile implements IRepositoryUnwanted {

    public RepositoryFile(String tempFilepath, String filename) {
        _path = tempFilepath;
        _fileName = filename;
        new File(_path).mkdirs();
    }

    private final String _path;
    private final String _fileName;

    @Override
    public UnwontedResponse GetResponse() throws Exception {
        UnwontedResponse response = new UnwontedResponse();

        String content = new String(Files.readAllBytes(Paths.get(_path + "/" + _fileName)));

        String[] rows = content.split("\r\n");

        for(String row : rows){
            UnwontedLegal legal = new UnwontedLegal(row);

            response.UnwontedLegals.add(legal);
        }

        return response;
    }
}