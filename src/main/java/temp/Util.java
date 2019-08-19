package temp;

import org.apache.kafka.clients.admin.AdminClient;

import java.util.Properties;
import java.util.function.Function;

public class Util {

    public static <T> T goat(Function<AdminClient, T> function){
       try(AdminClient client = AdminClient.create(new Properties())) {
           return function.apply(client);
       }
    }

    public static void main(String[] args) {
        goat(AdminClient::describeCluster);
    }

    public static <T> T stringGoat(Function<String, T> function){

        String mine = "hell";
        return function.apply(mine);

    }

    public static void string() {
        final String o = stringGoat(s -> s.concat("o"));
        System.out.println(o);
    }
}
