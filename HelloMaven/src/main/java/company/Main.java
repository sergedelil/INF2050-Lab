package company;

//import net.sf.json.*;
//import org.apache.commons.logging.*;

public class Main {

    //private static Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args){

        Exchange.permuter(15, 20);

        if (args.length != 1){
            System.out.println("Invalid argument...");
        }else {
            Reader.read(args[0]);
        }

        // tester json-lib
        //String settings = "{\"hello\": \"world\"}";
        //JSONObject obj = (JSONObject)JSONSerializer.toJSON(settings);
        //System.out.println("\n"+obj.toString());

        // tester Apache Commons Logging 1.2
        //log.info("in the main method");

    }
}
