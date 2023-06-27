package com.example.streamXpress.services;

import com.example.streamXpress.entities.*;
import com.example.streamXpress.exceptions.*;
import com.example.streamXpress.entities.Plan;
import com.example.streamXpress.repository.ChannelRepository;
import com.example.streamXpress.repository.PackageRepository;
import com.example.streamXpress.repository.SubscriptionRepository;
import com.example.streamXpress.repository.UserRepository;
import com.example.streamXpress.request.ChannelRequestDTO;
import com.example.streamXpress.request.PackageRequestDTO;
import com.example.streamXpress.request.SubscriptionRequestDto;
import com.example.streamXpress.request.UserRequestDto;
import com.example.streamXpress.response.ChannelResponseDTO;
import com.example.streamXpress.response.PackageResponseDTO;

import com.example.streamXpress.response.UserResponseDto;
import com.example.streamXpress.utilities.Constants;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StreamService implements IStreamService{

    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String subscribeToPackage(SubscriptionRequestDto request) {
        log.debug("subscribing a package starts");
        try {
            if(request==null){
               throw new InvalidSubscriptionException(StatusCode.BAD_REQUEST,Constants.SUBSCRIPTION_NOT_FOUND);
            }

            PackageEntity selectedPackage = packageRepository.findById(request.getPackId())
                    .orElseThrow(() -> new PackageNotFoundException(StatusCode.NOT_FOUND, Constants.PACKAGE_ID_NOT_FOUND));

            Subscription subscription = new Subscription();
            subscription.setName(request.getName());
            subscription.setUserId(request.getUserId());
            subscription.setPack(selectedPackage);
            subscription.setDuration(request.getDuration());
            subscriptionRepository.save(subscription);

            log.debug("subscribing a package ends");

            return "congrats! successfully subscribed a package";

        }catch (Exception ex){
            if(Constants.PACKAGE_ID_NOT_FOUND.equals(ex.getMessage())){
                throw new PackageNotFoundException(StatusCode.NOT_FOUND, Constants.PACKAGE_ID_NOT_FOUND);
            }
            throw new InvalidSubscriptionException(StatusCode.INTERNAL_SERVER_ERROR,Constants.SUBSCRIPTION_FAILED);
        }
    }

    @Override
    public String updatePackage(Long channelId,Plan duration,Long id) {
        log.debug("update subscription starts");
        try {

            if(channelId==null){
                throw new ChannelNotFoundException(StatusCode.BAD_REQUEST, Constants.CHANNEL_ID_NOT_FOUND);
            }
            Subscription subscription = subscriptionRepository.findById(id)
                    .orElseThrow(() -> new InvalidSubscriptionException(StatusCode.NOT_FOUND, Constants.SUBSCRIPTION_ID_NOT_FOUND));
            Channel channel = channelRepository.findById(channelId)
                    .orElseThrow(() -> new ChannelNotFoundException(StatusCode.NOT_FOUND, Constants.CHANNEL_NOT_FOUND));

            subscription.setSubscriptionId(id);

            channel.setChannelId(channelId);
            channel.setDuration(duration);

            subscription.setAddOnChannel(channel);

            subscriptionRepository.save(subscription);

            log.debug("update a subscription ends");

            return "congrats! successfully added a channel to your package";
        }catch (Exception ex){
            if(Constants.SUBSCRIPTION_ID_NOT_FOUND.equals(ex.getMessage())){
                throw new InvalidSubscriptionException(StatusCode.NOT_FOUND, Constants.SUBSCRIPTION_ID_NOT_FOUND);
            }else if(Constants.CHANNEL_NOT_FOUND.equals(ex.getMessage())){
                throw new ChannelNotFoundException(StatusCode.NOT_FOUND,Constants.CHANNEL_NOT_FOUND);
            }else if(Constants.CHANNEL_ID_NOT_FOUND.equals(ex.getMessage())){
                throw new ChannelNotFoundException(StatusCode.BAD_REQUEST, Constants.CHANNEL_ID_NOT_FOUND);
            }
            throw new InvalidSubscriptionException(StatusCode.INTERNAL_SERVER_ERROR,Constants.SUBSCRIPTION_UPDATE_FAILED);

        }
    }


    @Override
    public ChannelResponseDTO addChannel(ChannelRequestDTO request) {
        log.debug("adding channel starts");
        try {
            if(request==null){
                throw new ChannelNotFoundException(StatusCode.NO_CONTENT,Constants.CHANNEL_NOT_FOUND);
            }

            Channel channel = modelMapper.map(request, Channel.class);
            Channel entity = channelRepository.save(channel);
            ChannelResponseDTO response = modelMapper.map(entity, ChannelResponseDTO.class);
            log.debug("adding channel ends");

            return response;

        }catch (Exception ex){
            if(Constants.CHANNEL_NOT_FOUND.equals(ex.getMessage())){
                throw new ChannelNotFoundException(StatusCode.NO_CONTENT,Constants.CHANNEL_NOT_FOUND);
            }
            throw new ChannelNotFoundException(StatusCode.INTERNAL_SERVER_ERROR,Constants.ADDING_CHANNEL_FAILED);
        }
    }


    @Override
    public PackageResponseDTO addPackage(PackageRequestDTO request) {
        log.debug("adding package starts");
        try {
            if (request == null) {
                throw new PackageNotFoundException(StatusCode.NO_CONTENT, Constants.PACKAGE_NOT_FOUND);
            }
            PackageEntity defaultPackage = modelMapper.map(request, PackageEntity.class);
            PackageEntity savedEntity = packageRepository.save(defaultPackage);
            PackageResponseDTO response = modelMapper.map(savedEntity, PackageResponseDTO.class);

            log.debug("adding package ends");

            return response;
        }catch (Exception ex){
            if(Constants.CHANNEL_NOT_FOUND.equals(ex.getMessage())){
                throw new ChannelNotFoundException(StatusCode.NO_CONTENT,Constants.PACKAGE_NOT_FOUND);
            }
            throw new ChannelNotFoundException(StatusCode.INTERNAL_SERVER_ERROR,Constants.ADDING_PACKAGE_FAILED);
        }
    }


    @Override
    public UserResponseDto addUser(UserRequestDto request) {
        log.debug("adding user starts");
        try {
            if (request == null) {
                throw new UserNotFoundException(StatusCode.NO_CONTENT, Constants.USER_NOT_FOUND);
            }
            User user = modelMapper.map(request, User.class);
            User entity = userRepository.save(user);
            UserResponseDto response = modelMapper.map(entity, UserResponseDto.class);
            log.debug("adding user ends");
            return response;
        }catch (Exception ex){
            if(Constants.USER_NOT_FOUND.equals(ex.getMessage())){
                throw new ChannelNotFoundException(StatusCode.NO_CONTENT,Constants.USER_NOT_FOUND);
            }
            throw new ChannelNotFoundException(StatusCode.INTERNAL_SERVER_ERROR,Constants.ADDING_USER_FAILED);
        }
    }




}
