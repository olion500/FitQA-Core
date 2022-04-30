package com.cocovo.fitqaspringjava.infrastructure.video;

import com.cocovo.fitqaspringjava.domain.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}
