package com.example.streamXpress.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ChannelResponseDTO {

    @JsonProperty("channel_id")
    private Long channelId;

    @JsonProperty("channel_name")
    private String channelName;

    private Double cost;

    @JsonProperty("language")
    private String language;

    @JsonProperty("pack_id")
    private Long packId;
}
