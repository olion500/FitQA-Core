package com.cocovo.fitqaspringjava.infrastructure.trainer.component;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerUpdater;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class TrainerUpdaterImpl implements TrainerUpdater {
  @Override
  public Trainer updateTrainer(Trainer storedTrainer, TrainerCommand.UpdateTrainer updateTrainer) {
    storedTrainer
        .changeIntroduce(updateTrainer.getIntroduceTitle(), updateTrainer.getIntroduceContext());
    storedTrainer.changeStyle(updateTrainer.getStyle());

    // Career

    // FeedbackPrice

    // 지워, 생성, 변경


    // InterestArea

    // Sns

    return storedTrainer;
  }
}
