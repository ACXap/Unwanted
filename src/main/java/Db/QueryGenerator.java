package Db;


public class QueryGenerator {

    public QueryGenerator(String schema) {
        TABLE_LEGAL = schema + "unwanted_legal";
    }

    //region PrivateField
    private final String TABLE_LEGAL;

    private final String INSERT_INTO = "INSERT INTO ";
    //endregion PrivateField

    public String GetQueryInsertLegal() {
        return INSERT_INTO + TABLE_LEGAL
                + " (all_name,actual_date,list_id)"
                + " VALUES(?,?,?);";
    }

    public String GetQueryDeleteData() {
        String delete = "DELETE FROM ";
        return delete + TABLE_LEGAL + ";";
    }
}