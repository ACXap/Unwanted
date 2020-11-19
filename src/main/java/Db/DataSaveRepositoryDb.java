package Db;

import Data.DbConnectProperty;
import Data.EntityUnwanted;
import Interfaces.ISaveDataRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DataSaveRepositoryDb implements ISaveDataRepository {

    public DataSaveRepositoryDb(DbConnectProperty dbConnectProperty) throws Exception {
        _dbConnectProperty = dbConnectProperty;
        _queryGenerator = _dbConnectProperty.GetQueryGenerator();
    }

    //region PrivateField
    protected final QueryGenerator _queryGenerator;
    protected final DbConnectProperty _dbConnectProperty;
    //endregion PrivateField

    @Override
    public void AddUnwonted(List<EntityUnwanted> persons) throws SQLException {
        Connection con = _dbConnectProperty.GetConnection();

        try {
            con.setAutoCommit(false);

            AddUnwonted(persons, con);

            con.commit();
        } catch (SQLException sex) {
            con.rollback();
            con.close();
            throw sex;
        } finally {
            con.close();
        }
    }

    private void AddUnwonted(List<EntityUnwanted> persons, Connection con) throws SQLException {
        String query = _queryGenerator.GetQueryInsertLegal();

        try (PreparedStatement ps = con.prepareStatement(query)) {
            for (EntityUnwanted p : persons) {

                int parameterIndex = 1;
                ps.setString(parameterIndex++, p.AllName);
                ps.setObject(parameterIndex++, GetSqlDate(p.DateDoc));
                ps.setString(parameterIndex++, p.NumberDoc);

                ps.addBatch();
            }
            ps.executeBatch();
        }
    }


    private Object GetSqlDate(Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        }

        return null;
    }
}