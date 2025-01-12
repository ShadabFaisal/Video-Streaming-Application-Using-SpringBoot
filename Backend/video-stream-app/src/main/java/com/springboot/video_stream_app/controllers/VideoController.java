package com.springboot.video_stream_app.controllers;

import com.springboot.video_stream_app.entities.Video;
import com.springboot.video_stream_app.payload.CustomMessage;
import com.springboot.video_stream_app.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam("file")MultipartFile file,
                                                @RequestParam("title") String title,
                                                @RequestParam("description") String description){

        Video video=new Video();
        video.setTitle(title);
        video.setDescription(description);
        video.setVideoId(UUID.randomUUID().toString());


        Video savedVideo=videoService.save(video,file);

        if(savedVideo!=null){
            return ResponseEntity.ok(video);
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CustomMessage("Video not uploaded", false));
        }
    }

}
