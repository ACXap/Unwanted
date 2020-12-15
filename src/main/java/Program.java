import Data.EntityUnwanted;
import Db.DataSaveRepositoryDb;
import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwantedLegal;
import RepositoryUnwanted.Data.UnwantedResponse;
import RepositoryUnwanted.RepositoryFile;
import RepositoryUnwanted.RepositorySite;

import Service.PropertyService;

import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        PropertyService.Initialization();
        EntityUnwanted.SEPARATOR = PropertyService.DbSeparator;

        RepositorySite rep = new RepositorySite(PropertyService.UrlService);

        IRepositoryUnwanted rep2 = new RepositoryFile(PropertyService.PathTempFile, "unwanted.csv");

        UnwantedResponse response = rep.GetResponse();
        UnwantedResponse response2 = rep2.GetResponse();

        for (int i = 0; i < response.UnwantedLegals.size(); i++) {
            UnwantedLegal ul1 = response.UnwantedLegals.get(i);
            UnwantedLegal ul2 = response2.UnwantedLegals.get(i);
            System.out.println(ul1.equals(ul2));
        }


        List<EntityUnwanted> collection = EntityUnwanted.ConvertUnwantedLegal(response.UnwantedLegals);

        DataSaveRepositoryDb db = new DataSaveRepositoryDb(PropertyService.DbConnectProperty);
        db.AddUnwonted(collection);

    }
}