package com.socialmedia.pub.service;

import com.socialmedia.pub.dto.PublicationDTO;
import com.socialmedia.pub.entity.Publication;
import com.socialmedia.pub.entity.User;
import com.socialmedia.pub.exception.EntityNotFoundException;
import com.socialmedia.pub.mapper.PublicationMapper;
import com.socialmedia.pub.repository.PublicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.socialmedia.pub.exception.StatusCodes.ENTITY_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
public class PublicationServiceImpl implements PublicationService{

    private final PublicationMapper publicationMapper;

    private final PublicationRepository publicationRepository;

    @Override
    public PublicationDTO addPost(PublicationDTO publicationDTO) {
        Publication publication = publicationMapper.publicationDTOToPublication(publicationDTO);
        Publication savedPublication = publicationRepository.save(publication);
        return publicationMapper.publicationToPublicationDTO(savedPublication);
    }

    @Override
    public PublicationDTO editPost(UUID postId, PublicationDTO updatedPublicationDTO) {
        Publication existingPublication = publicationRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND.name(), "Post not found with UUID: " + postId));

        existingPublication.setTitle(updatedPublicationDTO.getTitle());
        existingPublication.setContent(updatedPublicationDTO.getContent());

        Publication updatedPublication = publicationRepository.save(existingPublication);
        return publicationMapper.publicationToPublicationDTO(updatedPublication);

    }

    @Override
    public void removePost(UUID postId) {
        Publication existingPublication = publicationRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND.name(), "Post not found with UUID: " + postId));

        publicationRepository.delete(existingPublication);
}

    @Override
    public void likePost(UUID postId, UUID userId) {

    }

    @Override
    public List<PublicationDTO> getPostsLikedByUser(User user) {
        List<Publication> publications = publicationRepository.findPublicationsLikedByUser(user);
        return publications.stream()
                .map(publicationMapper::publicationToPublicationDTO)
                .collect(Collectors.toList());
    }
}
