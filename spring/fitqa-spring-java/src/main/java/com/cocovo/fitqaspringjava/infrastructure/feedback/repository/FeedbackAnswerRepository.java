package com.cocovo.fitqaspringjava.infrastructure.feedback.repository;

import com.cocovo.fitqaspringjava.domain.feedback.entity.FeedbackAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackAnswerRepository extends JpaRepository<FeedbackAnswer, Long> {

}
