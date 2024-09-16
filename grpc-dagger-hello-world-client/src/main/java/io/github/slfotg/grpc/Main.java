package io.github.slfotg.grpc;

import io.github.slfotg.grpc.domain.HelloRequest;
import io.github.slfotg.grpc.mapping.RequestMapper;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Main Client Application.
 */
public class Main {

    /**
     * Main method.
     */
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        var request = new HelloRequest("Sam", "Foster", 38);
        var mapper = RequestMapper.INSTANCE;

        var hello = mapper.toHelloRequest(request);

        HelloReply helloResponse = stub.sayHello(hello);

        System.out.println(helloResponse.getMessage());

        channel.shutdown();
    }
}