package com.springboot.video_stream_app.services.impl;

import com.springboot.video_stream_app.entities.Video;
import com.springboot.video_stream_app.repositories.VideoRepository;
import com.springboot.video_stream_app.services.VideoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepo;

    @Value("${files.video}")
    String DIR;

    @PostConstruct
    public void init(){
        File file=new File(DIR);

        if(!file.exists()){
            file.mkdir();
            System.out.println("Folder created: ");
        }
        else{
            System.out.println("Folder already created!!! ");
        }
    }

    @Override
    public Video save(Video video, MultipartFile file) {

        try {

            String filename=file.getOriginalFilename();
            String contentType=file.getContentType();
            InputStream inputStream=file.getInputStream();


            //Clean folder path
            //String cleanFilename= StringUtils.cleanPath(filename);
            String cleanFolder=StringUtils.cleanPath(DIR);

            //Create folder path with filename
            Path path= Paths.get(cleanFolder,filename);
            System.out.println(contentType);
            System.out.println(path);

            //copy file to the folder
            Files.copy(inputStream,path, StandardCopyOption.REPLACE_EXISTING);

            //set video metadata
            video.setContentType(contentType);
            video.setFilePath(path.toString());

            //save video metadata in the database
            return videoRepo.save(video);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
