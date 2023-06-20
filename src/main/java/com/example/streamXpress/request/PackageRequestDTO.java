package com.example.streamXpress.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PackageRequestDTO {

    @JsonProperty("pack_id")
    private Long packId;

    @JsonProperty("name")
    private String name;
}
