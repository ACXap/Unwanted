import Data.EntityUnwanted;
import Db.DataSaveRepositoryDb;
import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwantedResponse;
import RepositoryUnwanted.RepositoryFile;
import RepositoryUnwanted.RepositorySite;
import Service.HttpServiceApache;
import Service.PropertyService;

import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        PropertyService.Initialization();
        EntityUnwanted.SEPARATOR = PropertyService.DbSeparator;


        RepositorySite rep = new RepositorySite(new HttpServiceApache(PropertyService.UrlService,PropertyService.InternetConnectProperty));

        //IRepositoryUnwanted rep = new RepositoryFile(PropertyService.PathTempFile, "unwanted.csv");

        UnwantedResponse response = rep.GetResponse();

        List<EntityUnwanted> collection = EntityUnwanted.ConvertUnwantedLegal(response.unwantedLegals);

        DataSaveRepositoryDb db = new DataSaveRepositoryDb(PropertyService.DbConnectProperty);
        db.AddUnwonted(collection);

    }
}