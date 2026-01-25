package uz.pdp;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {


    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.country", target = "country")
    UserProfileDTO toUserProfile( UserDTO user, AddressDTO address );
}