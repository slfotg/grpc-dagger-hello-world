package io.github.slfotg.grpc;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.grpc.server.ForGrpcService;
import io.github.slfotg.grpc.server.HelloServiceDefinition;
import io.grpc.ServerInterceptor;
import java.util.Arrays;
import java.util.List;

@Module
abstract class MyModule {
    @Binds
    abstract HelloServiceDefinition helloComponent(MyComponent myComponent);

    @Provides
    @ForGrpcService(HelloServiceGrpc.class)
    static List<? extends ServerInterceptor> helloInterceptors() {
        return Arrays.asList();
    }
}
