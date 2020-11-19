package Interfaces;

import Data.EntityUnwonted;

import java.sql.SQLException;
import java.util.List;

public interface ISaveDataRepository {

    void AddUnwonted(List<EntityUnwonted> persons) throws SQLException;
}