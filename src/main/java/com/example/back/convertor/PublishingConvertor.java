package com.example.back.convertor;

import com.example.back.dto.Publishing.PublishingDto;
import com.example.back.models.Publishing;

public class PublishingConvertor {
    public static PublishingDto mapToPublishingDto(Publishing publishing) {
        PublishingDto publishingDto = new PublishingDto();
        publishingDto.setId(publishing.getId());
        publishingDto.setTitle(publishing.getTitle());
        publishingDto.setDescription(publishing.getDescription());
        publishingDto.setPhone(publishing.getPhone());
        publishingDto.setEmail(publishing.getEmail());
        return publishingDto;
    }

    public static Publishing mapToPublishing(PublishingDto publishingDto) {
        Publishing publishing = new Publishing();
        publishing.setId(publishingDto.getId());
        publishing.setTitle(publishingDto.getTitle());
        publishing.setDescription(publishingDto.getDescription());
        publishing.setPhone(publishingDto.getPhone());
        publishing.setEmail(publishingDto.getEmail());
        return publishing;
    }
}
