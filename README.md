# China Office365 Graph SDK Demo for Java
A Java SDK Demo for 21vianet Office 365 within graph api.


Have to change the service root url to china endpoint, otherwise authentication will not find the correct national cloud.  

Using ``import com.microsoft.graph.models.extensions.IGraphServiceClient`` to change the serviceroot.

```java

graphServiceClient.setServiceRoot( "https://microsoftgraph.chinacloudapi.cn/v1.0" );
```
