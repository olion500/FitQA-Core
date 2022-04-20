package com.cocovo.fitqaspringjava.infrastructure.feedback.repository;

import com.cocovo.fitqaspringjava.domain.feedback.entity.FeedbackComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackCommentRepository extends JpaRepository<FeedbackComment, Long> {

}
