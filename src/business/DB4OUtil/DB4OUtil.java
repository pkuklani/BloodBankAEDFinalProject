package business.DB4OUtil;

import business.ConfigureABusiness;
import business.Business;
//import business.Ecosystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

/**
 *
 * @author pkuklani 
 * @author pkuklani
 */
public class DB4OUtil {

    private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString();// path to the data store
    private static DB4OUtil dB4OUtil;
    private Business system;

    public synchronized static DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        System.out.println("connect");
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(Business.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            System.out.println("db" + db);
            //   ObjectSet result=db.queryByExample(db);
            //   if(result==null) System.out.println("null");
            //   else System.out.println(" not null");

            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(Business system) {
        ObjectContainer conn = createConnection();
        System.out.println("instoredconn   " + conn);
        // conn.delete(system);
        //conn.store(system);
        try {
            conn.ext().store(conn, 1);
            System.out.println("stored");
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            // conn.close();
            System.out.println("exceptionstored");
        }

    }

    public Business retrieveSystem() {
        ObjectContainer conn = createConnection();
        System.out.println("connretrieve  " + conn);
        Business system;
        try {
            // ObjectSet<Business> systems =conn.ext().queryByExample(Business.class);
            // ObjectSet<Business> systems =conn.queryByExample(Business.class);
            ObjectSet<Business> systemsQ = conn.query(Business.class);
            ObjectSet<Business> systems = conn.query(Business.class);
            // ObjectSet<Business> systems = conn.query(Business.class); // Change to the object you want to save
            //  Business system;
            if (systems.size() == 0) {
                system = ConfigureABusiness.configure();  // If there's no System in the record, create a new one
            } else {
                system = systems.get(systems.size() - 1);
            }
            System.out.println("retrieve closing conn");
            conn.close();
            return system;
        } catch (Exception ex) {
            // conn.close();
            // = ConfigureABusiness.configure();
            // conn.store(system);
            conn.close();
            var errorMessage = ex.getMessage();
            System.out.println("exceptionretrieve" + ex.getMessage());
            try {
                return ConfigureABusiness.configure();
            } catch (Exception fex) {
                return null;
            }
        }

        //system = ConfigureABusiness.configure();
        //return null;//system;
    }
}
