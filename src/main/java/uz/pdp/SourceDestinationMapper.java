package uz.pdp;

import org.mapstruct.Mapper;

import javax.print.attribute.standard.Destination;
import javax.xml.transform.Source;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SourceDestinationMapper {
    Destination toDestination( Source source );

    List<Destination> toDestinationList( List<Source> sources );
}