package Interfaces;

import Data.EntityUnwanted;

import java.sql.SQLException;
import java.util.List;

public interface ISaveDataRepository {

    void AddUnwonted(List<EntityUnwanted> persons) throws SQLException;
}