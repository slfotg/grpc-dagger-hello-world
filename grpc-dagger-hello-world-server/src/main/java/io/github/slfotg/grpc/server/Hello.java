package io.github.slfotg.grpc.server;

import dagger.grpc.server.GrpcService;
import io.github.slfotg.grpc.HelloReply;
import io.github.slfotg.grpc.HelloRequest;
import io.github.slfotg.grpc.HelloServiceGrpc;
import io.github.slfotg.grpc.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;
import javax.inject.Inject;

/**
 * Hello Service implementation.
 */
@GrpcService(grpcClass = HelloServiceGrpc.class)
public class Hello extends HelloServiceImplBase {

    @Inject
    public Hello() {
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        var first = request.getName().getFirst();
        var last = request.getName().getLast();
        var name = first + " " + last;
        responseObserver.onNext(
                HelloReply.newBuilder()
                        .setMessage("Hello " + name)
                        .build());
        responseObserver.onCompleted();
    }

}
