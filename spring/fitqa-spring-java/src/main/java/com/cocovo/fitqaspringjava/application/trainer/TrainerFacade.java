package com.cocovo.fitqaspringjava.application.trainer;


import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;
import com.cocovo.fitqaspringjava.domain.feedback.service.FeedbackService;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.trainer.service.TrainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

  public TrainerInfo.Main retrieveTrainerInfo(String trainerToken) {
    return trainerService.retrieveTrainerByToken(trainerToken);
  }

  public List<TrainerInfo.Main> retrieveTrainers(
      TrainerCommand.RetrieveTrainersByInterestAreas interestAreas) {
    return trainerService.retrieveTrainers(interestAreas);
  }

  public List<TrainerInfo.Main> retrieveTrainers() {
    return trainerService.retrieveTrainers();
  }

  public List<FeedbackInfo.Main> getFeedbacksOfTrainer(String trainerToken) {
    var trainer = trainerService.retrieveTrainerByToken(trainerToken);
    return feedbackService.retrieveFeedbacksByTrainerId(trainer.getId());
  }

  public TrainerInfo.Main updateTrainerInterestAreas(String trainerToken,
                                                     TrainerCommand.UpdateTrainerByInterestAreas updateInterestAreas) {
    return trainerService.updateTrainerInterestAreas(trainerToken, updateInterestAreas);
  }

  public TrainerInfo.Main updateTrainerInfo(String trainerToken,
                                            TrainerCommand.UpdateTrainerInfo updateTrainerInfo) {
    return trainerService.updateTrainerInfo(trainerToken, updateTrainerInfo);

  }
}
