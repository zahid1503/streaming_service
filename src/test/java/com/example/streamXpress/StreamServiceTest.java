package com.example.streamXpress;

import com.example.streamXpress.entities.Channel;
import com.example.streamXpress.entities.PackageEntity;
import com.example.streamXpress.entities.Plan;
import com.example.streamXpress.entities.Subscription;
import com.example.streamXpress.repository.ChannelRepository;
import com.example.streamXpress.repository.PackageRepository;
import com.example.streamXpress.repository.SubscriptionRepository;
import com.example.streamXpress.request.SubscriptionRequestDto;
import com.example.streamXpress.services.StreamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StreamServiceTest {

    @Mock
    private PackageRepository packageRepository;
    @Mock
    private ChannelRepository channelRepository;
    @Mock
    private SubscriptionRepository subscriptionRepository;

        @InjectMocks
        private StreamService streamService;

        @Test
        @DisplayName("Test updatePackage - Successful update")
        public void updatePackageTest(){
            Long channelId = 9L;
            Long id =8L;
            Plan duration = Plan.MONTHLY;

            Subscription subscription = new Subscription();

            Channel channel = new Channel();

            Mockito.when(subscriptionRepository.findById(id)).thenReturn(Optional.of(subscription));

            Mockito.when(channelRepository.findById(channelId)).thenReturn(Optional.of(channel));

            String result = streamService.updatePackage(channelId,duration,id);

            Assertions.assertEquals("congrats! successfully added a channel to your package" , result);

            Mockito.verify(subscriptionRepository).save(subscription);
        }

        @Test
    @DisplayName("Test subscribe to package -subscribe successful ")
    public void subscribeToPackageTest(){

            SubscriptionRequestDto request = new SubscriptionRequestDto();

            PackageEntity selectedPackage = new PackageEntity();

            Subscription subscription = new Subscription();

            Mockito.when(packageRepository.findById(request.getPackId())).thenReturn(Optional.of(selectedPackage));

            String result = streamService.subscribeToPackage(request);

            Assertions.assertEquals("congrats! successfully subscribed a package",result);

            Mockito.verify(subscriptionRepository).save(Mockito.any(Subscription.class));
        }


}
