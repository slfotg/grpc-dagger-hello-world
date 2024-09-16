package io.github.slfotg.grpc.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Maps requests.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.JSR330,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RequestMapper {

    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    /**
     * Maps a request.
     *
     * @param request the domain request
     * @return the grpc request
     */
    @Mapping(target = "name.first", source = "first")
    @Mapping(target = "name.last", source = "last")
    io.github.slfotg.grpc.HelloRequest toHelloRequest(
            io.github.slfotg.grpc.domain.HelloRequest request);
}
