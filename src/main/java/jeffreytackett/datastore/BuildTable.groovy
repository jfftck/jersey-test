package jeffreytackett.datastore

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

/**
 * Created by Jeffrey on 2015-11-19.
 */
class BuildTable {
    /*
    *  Build the H2 database table and import the data from the CSV.
    *
    *  This should be deleted after first run or never run again as it would wipe the data,
    *  but since this app does not modify the data this class does not present a real danger.
    * */
    public static void main(String[] args) throws IOException {
        Connection conn

        Class.forName("org.h2.Driver")

        try {
            conn = DriverManager.getConnection("jdbc:h2:~/data/test", "sa", "")
            Statement stmt = conn.createStatement()

            stmt.execute("DROP TABLE IF EXISTS Inventory")
            stmt.execute("CREATE TABLE Inventory(" +
                    "category VARCHAR_IGNORECASE(500)," +
                    "itemId INT PRIMARY KEY," +
                    "parentCategory VARCHAR_IGNORECASE(500)," +
                    "title VARCHAR_IGNORECASE(500)," +
                    "imageUrl VARCHAR_IGNORECASE(500)," +
                    "itemHashint64 BIGINT," +
                    "upc BIGINT," +
                    "modifiedDate TIMESTAMP," +
                    "createdDate TIMESTAMP," +
                    "department VARCHAR_IGNORECASE(500)," +
                    "popularityIndex VARCHAR_IGNORECASE(10)," +
                    "brand VARCHAR_IGNORECASE(256)," +
                    "isActive BOOLEAN" +
                    ") AS SELECT" +
                    "* FROM CSVREAD('~/data/products.csv')")
        } catch (Exception e) {
            throw e
        } finally {
            try {
                conn.close()
            } finally {
                // Connection must have failed.
            }
        }
    }
}
