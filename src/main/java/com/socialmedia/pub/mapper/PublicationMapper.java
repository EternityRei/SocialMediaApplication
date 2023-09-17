package com.socialmedia.pub.mapper;

import com.socialmedia.pub.dto.PublicationDTO;
import com.socialmedia.pub.entity.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublicationMapper {
    PublicationMapper INSTANCE = Mappers.getMapper(PublicationMapper.class);

    PublicationDTO publicationToPublicationDTO(Publication post);

    Publication publicationDTOToPublication(PublicationDTO postDTO);
}
