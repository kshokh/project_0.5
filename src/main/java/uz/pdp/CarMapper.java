package uz.pdp;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface CarMapper {


    @Mapping(target = "id", expression = "java(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE)")
    Car toEntity( CarDTO carDTO );
}
