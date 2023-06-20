package com.example.streamXpress.controller;


import com.example.streamXpress.entities.Plan;
import com.example.streamXpress.request.ChannelRequestDTO;
import com.example.streamXpress.request.PackageRequestDTO;
import com.example.streamXpress.request.SubscriptionRequestDto;
import com.example.streamXpress.request.UserRequestDto;
import com.example.streamXpress.response.ChannelResponseDTO;

import com.example.streamXpress.response.PackageResponseDTO;
import com.example.streamXpress.response.UserResponseDto;
import com.example.streamXpress.services.IStreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stream")
public class StreamController {

    @Autowired
    private IStreamService streamService;

    @PostMapping("/add_package")
    public ResponseEntity<PackageResponseDTO> createPackage(@RequestBody PackageRequestDTO request){
        PackageResponseDTO response = streamService.addPackage(request);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/update_package")
    public ResponseEntity<String> addOnPackage(@RequestParam(name = "channelId") Long channelId, @RequestParam(name = "duration") Plan duration, @RequestParam(name = "id") Long id){
        String response = streamService.updatePackage(channelId,duration,id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> createSubscription(@RequestBody SubscriptionRequestDto request) {
        String response = streamService.subscribeToPackage(request);
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/add_channel")
    public ResponseEntity<ChannelResponseDTO> createChannel(@RequestBody ChannelRequestDTO request){
        ChannelResponseDTO response = streamService.addChannel(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add_user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto request){
        UserResponseDto response = streamService.addUser(request);
        return ResponseEntity.ok().body(response);
    }

}
