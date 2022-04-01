package com.cocovo.fitqaspringjava.infrastructure.trainer.component;

import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerStore;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import com.cocovo.fitqaspringjava.infrastructure.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TrainerStoreImpl implements TrainerStore {
  private final TrainerRepository trainerRepository;
  private final Trainer

  @Override
  public Trainer registerTrainer(Trainer initTrainer) {
    return trainerRepository.save(initTrainer);
  }
}
