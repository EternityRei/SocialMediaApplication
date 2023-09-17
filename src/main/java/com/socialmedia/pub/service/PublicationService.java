package com.socialmedia.pub.service;

import com.socialmedia.pub.dto.PublicationDTO;
import com.socialmedia.pub.entity.User;

import java.util.List;
import java.util.UUID;

public interface PublicationService {
    PublicationDTO addPost(PublicationDTO publicationDTO);
    PublicationDTO editPost(UUID postId, PublicationDTO updatedPublicationDTO);
    void removePost(UUID postId);
    void likePost(UUID postId, UUID userId);
    List<PublicationDTO> getPostsLikedByUser(User user);
}

