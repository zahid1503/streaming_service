package com.example.streamXpress;

import com.example.streamXpress.controller.StreamController;
import com.example.streamXpress.entities.PackageEntity;
import com.example.streamXpress.repository.PackageRepository;
import com.example.streamXpress.request.PackageRequestDTO;
import com.example.streamXpress.response.PackageResponseDTO;
import com.example.streamXpress.services.IStreamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class StreamControllerTest {

    @Mock
    private IStreamService streamService;
    @Mock
    private PackageRepository packageRepository;
    @InjectMocks
    private StreamController streamController;

    @Test
    @DisplayName("execute method of createPackage should return error if request is not found")
    public void testCreatePackage() {

        PackageRequestDTO request = new PackageRequestDTO();

        PackageEntity savedEntity = new PackageEntity();

        PackageResponseDTO expectedResponse = new PackageResponseDTO();

        Mockito.when(packageRepository.save(Mockito.any(PackageEntity.class))).thenReturn(savedEntity);

        PackageResponseDTO response = streamService.addPackage(request);

        Assertions.assertEquals(expectedResponse, response);

        Mockito.verify(packageRepository).save(Mockito.any(PackageEntity.class));
    }
}
