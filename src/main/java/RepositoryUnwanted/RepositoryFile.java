package RepositoryUnwanted;

import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwantedLegal;
import RepositoryUnwanted.Data.UnwantedResponse;

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
    public UnwantedResponse GetResponse() throws Exception {
        UnwantedResponse response = new UnwantedResponse();

        String content = new String(Files.readAllBytes(Paths.get(_path + "/" + _fileName)));

        String[] rows = content.split("\r\n");

        for(String row : rows){
            UnwantedLegal legal = new UnwantedLegal(row);

            response.UnwantedLegals.add(legal);
        }

        return response;
    }
}