package io.github.slfotg.grpc.domain;

/**
 * Request for the hello service.
 */
public record HelloRequest(String first, String last, int age) {
}
