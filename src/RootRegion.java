import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.auth.confidentialClient.ClientCredentialProvider;
import com.microsoft.graph.auth.enums.NationalCloud;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.requests.extensions.GraphServiceClient;

import java.util.ArrayList;

public class RootRegion {
    private String clientId="YourClientID";
    private String clientSecret="YourClientSecret";
    private String grantType = "client_credentials";
    private String tokenEndpoint = "https://login.partner.microsoftonline.cn/{teantId}/oauth2/v2.0/token";
    private String resourceId = "https://microsoftgraph.chinacloudapi.cn/.default";
    private String teantId = "YourTenantID";

    public IGraphServiceClient graphServiceClient = null;
    public IGraphServiceClient GetClient(boolean authenticate)
    {
        if (graphServiceClient == null) {
            try {
                ArrayList<String> scope = new ArrayList();
                scope.add( resourceId );

                ClientCredentialProvider authProvider = new ClientCredentialProvider(
                        clientId,
                        scope,
                        clientSecret,
                        teantId,
                        NationalCloud.China);

                graphServiceClient = GraphServiceClient.builder().authenticationProvider( authProvider ).buildClient();
                graphServiceClient.setServiceRoot( "https://microsoftgraph.chinacloudapi.cn/v1.0" );
                graphServiceClient = graphServiceClient;
                return graphServiceClient;
            }
            catch (Exception e)
            {
                throw new Error("Could not create a graph client: " + e.getLocalizedMessage());

            }

        }
        return graphServiceClient;
    }
}
