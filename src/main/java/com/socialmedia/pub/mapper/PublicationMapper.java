package com.socialmedia.pub.mapper;

import com.socialmedia.pub.dto.PublicationDTO;
import com.socialmedia.pub.entity.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublicationMapper {
    PublicationMapper INSTANCE = Mappers.getMapper(PublicationMapper.class);

    PublicationDTO publicationToPublicationDTO(Publication post);
    List<PublicationDTO> publicationListToPublicationDTOList(List<Publication> posts);

    Publication publicationDTOToPublication(PublicationDTO postDTO);
    List<Publication> publicationDTOListToPublicationList(List<PublicationDTO> postDTOs);
}
