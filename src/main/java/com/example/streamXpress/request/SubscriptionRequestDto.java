package com.example.streamXpress.request;

import com.example.streamXpress.entities.Channel;
import com.example.streamXpress.entities.Plan;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class SubscriptionRequestDto {
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("pack_id")
    private Long packId;

    @Enumerated(EnumType.STRING)
    @JsonProperty("duration")
    private Plan duration;

    @JsonProperty("channel_id")
    private Long addOnChannel;

}
