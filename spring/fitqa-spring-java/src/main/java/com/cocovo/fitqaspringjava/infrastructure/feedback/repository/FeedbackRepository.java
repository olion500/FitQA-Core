package com.cocovo.fitqaspringjava.infrastructure.feedback.repository;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Optional<Feedback> findByFeedbackToken(String feedbackToken);

}
