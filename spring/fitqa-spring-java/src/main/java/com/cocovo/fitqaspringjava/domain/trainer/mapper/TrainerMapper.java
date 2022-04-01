package com.cocovo.fitqaspringjava.domain.trainer.mapper;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.trainer.entity.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TrainerMapper {
  @Mapping(target = "name", ignore = true)
  @Mapping(target = "likesCount", ignore = true)
  @Mapping(target = "images", ignore = true)
  Trainer of(TrainerCommand.UpdateTrainer updateTrainer);

  // ToDo(in.heo): How to map trainer property?
  @Mapping(target = "trainer", ignore = true)
  TrainerCareer of(TrainerCommand.UpdateTrainerCareer updateTrainerCareer);

  @Mapping(target = "trainer", ignore = true)
  TrainerFeedbackPrice of(TrainerCommand.UpdateTrainerFeedbackPrice updateTrainerFeedbackPrice);

  @Mapping(target = "trainer", ignore = true)
  TrainerInterestArea of(TrainerCommand.UpdateTrainerInterestArea updateTrainerInterestArea);

  @Mapping(target = "trainer", ignore = true)
  TrainerSns of(TrainerCommand.UpdateTrainerSns updateTrainerSns);
}
