package com.example.streamXpress.repository;

import com.example.streamXpress.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long>{
}
