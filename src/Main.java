import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.graph.requests.extensions.SiteCollectionPage;
import org.json.JSONObject;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        RootRegion rootRegion = new RootRegion();
        SiteCollectionPage site = (SiteCollectionPage) rootRegion.GetClient(true).sites().buildRequest().get();

        JsonObject rawObject = site.getRawObject();
        Set<String> strings = rawObject.keySet();
        System.out.println(strings);
        JsonElement value = rawObject.get("value");
        System.out.println(value.toString());
    }
}