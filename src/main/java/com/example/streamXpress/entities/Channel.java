package com.example.streamXpress.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="channel")
@JsonIgnoreProperties
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "channel_id")
    @JsonProperty("channel_id")
    private Long channelId;

    @Column(name = "channel_name")
    @JsonProperty("channel_name")
    private String channelName;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "language")
    private String language;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="pack_id")
    @JsonProperty("pack_id")
    private PackageEntity pack;

    @Enumerated(EnumType.STRING)
    @JsonProperty("duration")
    @JoinColumn(name="duration")
    private Plan duration;
}
