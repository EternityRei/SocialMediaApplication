package com.socialmedia.pub.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonTypeName("PUBLICATION")
public class PublicationDTO {
    private String id;
    private String title;
    private String content;
    private UUID authorId;
    private String authorUsername;
    private Date creationDate;
    private int likesCount;
}
