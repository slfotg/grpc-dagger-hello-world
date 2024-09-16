package io.github.slfotg.grpc;

import dagger.Component;
import dagger.grpc.server.NettyServerModule;
import io.github.slfotg.grpc.server.HelloServiceDefinition;
import io.github.slfotg.grpc.server.HelloUnscopedGrpcServiceModule;
import io.grpc.Server;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    NettyServerModule.class,
    HelloUnscopedGrpcServiceModule.class,
    MyModule.class,
})
interface MyComponent extends HelloServiceDefinition {
    Server server();
}