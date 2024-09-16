package io.github.slfotg.grpc;

import dagger.grpc.server.NettyServerModule;
import io.grpc.Server;
import java.io.IOException;

/**
 * Main class.
 */
public class Main {
    /**
     * Start the server.
     */
    public static void main(String[] args) {
        System.out.println("Hello World");
        int port = 8888;
        MyComponent component = DaggerMyComponent.builder()
                .nettyServerModule(NettyServerModule.bindingToPort(port))
                .build();
        Server server = component.server();

        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}