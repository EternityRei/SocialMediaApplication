package com.socialmedia.pub.repository;

import com.socialmedia.pub.entity.Publication;
import com.socialmedia.pub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, UUID> {
    @Query("SELECT p FROM Publication p WHERE p.likesCount > 0 AND p.user.id = :userId")
    List<Publication> findPublicationsLikedByUser(User user);

    Optional<Publication> findPublicationById (UUID id);
}
