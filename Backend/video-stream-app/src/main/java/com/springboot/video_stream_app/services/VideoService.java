package com.springboot.video_stream_app.services;

import com.springboot.video_stream_app.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {

    Video save(Video video, MultipartFile file);

    Video getVideoById(String videoId);

    Video getVideoByTitle(String title);

    List<Video> getAllVideos();
}
