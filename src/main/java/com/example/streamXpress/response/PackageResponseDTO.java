package com.example.streamXpress.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@Data
public class PackageResponseDTO {

    @JsonProperty("pack_id")
    private Long packId;

    @JsonProperty("name")
    private String name;

}
