package com.example.streamXpress.services;

import com.example.streamXpress.entities.Plan;
import com.example.streamXpress.request.ChannelRequestDTO;
import com.example.streamXpress.request.PackageRequestDTO;
import com.example.streamXpress.request.SubscriptionRequestDto;
import com.example.streamXpress.request.UserRequestDto;
import com.example.streamXpress.response.ChannelResponseDTO;
import com.example.streamXpress.response.PackageResponseDTO;
import com.example.streamXpress.response.UserResponseDto;
import org.springframework.web.bind.annotation.RequestBody;


public interface IStreamService {

    String subscribeToPackage(SubscriptionRequestDto request);

    ChannelResponseDTO addChannel(ChannelRequestDTO request);

    PackageResponseDTO addPackage(@RequestBody PackageRequestDTO request) ;

    UserResponseDto addUser(UserRequestDto request);

    String updatePackage(Long channelId, Plan duration,Long id);


}
