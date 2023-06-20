package com.example.streamXpress.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "subscription")
public class Subscription{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("subscription_id")
    @Column(name = "subscription_id")
    private Long subscriptionId;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pack_id",nullable = true)
    @JsonProperty("pack_id")
    private PackageEntity pack ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "channel_id",nullable = true)
    @JsonProperty("channel_id")
    private Channel addOnChannel;

    @JsonProperty("user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    @JsonProperty("duration")
    private Plan duration;

}
