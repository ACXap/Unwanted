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
        UnwantedResponse response = rep.GetResponse();

        List<EntityUnwanted> collection = EntityUnwanted.ConvertUnwantedLegal(response.UnwantedLegals);

        DataSaveRepositoryDb db = new DataSaveRepositoryDb(PropertyService.DbConnectProperty);
        db.DeleteData();
        db.AddUnwonted(collection);
    }
}