package com.cocovo.fitqaspringjava.application.trainer;


import com.cocovo.fitqaspringjava.domain.feedback.service.FeedbackService;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo.TrainerWithFeedback;
import com.cocovo.fitqaspringjava.domain.trainer.service.TrainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainerFacade {

  private final TrainerService trainerService;
  private final FeedbackService feedbackService;

  public String registerTrainer(TrainerCommand.RegisterTrainer registerTrainer) {
    return trainerService.registerTrainer(registerTrainer);
  }

  public TrainerWithFeedback retrieveTrainerInfo(String trainerToken) {
    return trainerService.retrieveTrainerByToken(trainerToken);
  }

  public TrainerInfo.Main retrieveTrainerInfoByEmail(String email) {
    return trainerService.retrieveTrainerByEmail(email);
  }

  public List<TrainerWithFeedback> retrieveTrainers(
      TrainerCommand.RetrieveTrainersByInterestAreas interestAreas, Pageable pageable) {
    return trainerService.retrieveTrainers(interestAreas, pageable);
  }

  public List<TrainerWithFeedback> retrieveTrainers(Pageable pageable) {
    return trainerService.retrieveTrainers(pageable);
  }

  public TrainerWithFeedback updateTrainerInterestAreas(String trainerToken,
      TrainerCommand.UpdateTrainerByInterestAreas updateInterestAreas) {
    return trainerService.updateTrainerInterestAreas(trainerToken, updateInterestAreas);
  }

  public TrainerWithFeedback updateTrainerInfo(String trainerToken,
      TrainerCommand.UpdateTrainerInfo updateTrainerInfo) {
    return trainerService.updateTrainerInfo(trainerToken, updateTrainerInfo);

  }
}
