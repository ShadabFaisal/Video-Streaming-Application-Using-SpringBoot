package com.springboot.video_stream_app.repositories;

import com.springboot.video_stream_app.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
