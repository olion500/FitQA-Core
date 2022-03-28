package com.cocovo.fitqaspringjava.application.trainer;


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
}
