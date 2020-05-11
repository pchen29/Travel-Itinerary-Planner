import ratpack.server.RatpackServer;

public class Main {
    public static void main (String args[]) throws Exception {
        //Start Server
        RatpackServer.start(serverDefinition ->
                serverDefinition.handlers(chain->
                        chain.post("travel/information",new TravelInformationHandler())));

    }

}