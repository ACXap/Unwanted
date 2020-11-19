import Data.EntityUnwonted;
import Db.DataSaveRepositoryDb;
import Interfaces.IRepositoryUnwanted;
import RepositoryUnwanted.Data.UnwontedResponse;
import RepositoryUnwanted.RepositoryFile;
import Service.PropertyService;

import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        PropertyService.Initialization();
        EntityUnwonted.SEPARATOR = PropertyService.DbSeparator;


        //RepositorySite rep = new RepositorySite(new HttpServiceApache(PropertyService.UrlService,PropertyService.InternetConnectProperty));

        IRepositoryUnwanted rep = new RepositoryFile(PropertyService.PathTempFile, "unwanted.csv");

        UnwontedResponse response = rep.GetResponse();

        List<EntityUnwonted> collection = EntityUnwonted.ConvertUnwantedLegal(response.UnwontedLegals);

        DataSaveRepositoryDb db = new DataSaveRepositoryDb(PropertyService.DbConnectProperty);
        db.AddUnwonted(collection);

    }
}