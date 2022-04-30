package com.cocovo.fitqaspringjava.infrastructure.video;

import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoFeedbackWaitingRepository extends JpaRepository<VideoFeedbackWaiting, Long> {
    Optional<VideoFeedbackWaiting> findByVideoKey(String videoKey);

}
