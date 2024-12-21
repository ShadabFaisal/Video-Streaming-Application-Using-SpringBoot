package com.springboot.video_stream_app.services.impl;

import com.springboot.video_stream_app.entities.Video;
import com.springboot.video_stream_app.services.VideoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class VideoServiceImpl implements VideoService {

    @Value("${files.video}")
    String DIR;

    @Override
    public Video save(Video video, MultipartFile file) {

        try {

            String filename=file.getOriginalFilename();
            String contentType=file.getContentType();
            InputStream inputStream=file.getInputStream();


            //create folder path
            String cleanFilename= StringUtils.cleanPath(filename);
            String cleanFolder=StringUtils.cleanPath(DIR);

            Path path= Paths.get(cleanFolder,cleanFilename);

            //folder path with filename

            //copy file to the folder

            //get video metadata

            //save video metadata in the database
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Video getVideoById(String videoId) {
        return null;
    }

    @Override
    public Video getVideoByTitle(String title) {
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return List.of();
    }
}
