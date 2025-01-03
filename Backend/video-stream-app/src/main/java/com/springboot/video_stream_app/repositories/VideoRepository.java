package com.springboot.video_stream_app.repositories;

import com.springboot.video_stream_app.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, String> {

    Optional<Video> findByTitle(String title);
}
