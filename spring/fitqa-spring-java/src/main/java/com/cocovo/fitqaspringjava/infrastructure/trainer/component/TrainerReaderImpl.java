package com.cocovo.fitqaspringjava.infrastructure.trainer.component;

import com.cocovo.fitqaspringjava.common.exception.EntityNotFoundException;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerReader;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import com.cocovo.fitqaspringjava.infrastructure.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TrainerReaderImpl implements TrainerReader {

  private final TrainerRepository trainerRepository;

  @Override
  public Trainer retrieveTrainerByToken(String trainerToken) {
    return trainerRepository.getByTrainerToken(trainerToken);
  }

  @Override
  public Trainer retrieveTrainerByEmail(String email) {
    return trainerRepository.findByEmail(email)
            .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public List<Trainer> retrieveTrainersByInterestAreas(
      List<WorkOutType.InterestArea> interestAreaList) {
    return trainerRepository.findAllByInterestAreasIn(interestAreaList);
  }

  @Override
  public Page<Trainer> retrieveTrainersAll(Pageable pageable) {
    return trainerRepository.findAll(pageable);
  }
}
