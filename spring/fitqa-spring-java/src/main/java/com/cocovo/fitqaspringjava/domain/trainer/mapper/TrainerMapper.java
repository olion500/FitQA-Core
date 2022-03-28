package com.cocovo.fitqaspringjava.domain.trainer.mapper;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TrainerMapper {
  @Mapping(target = "name", ignore = true)
  Trainer of(TrainerCommand.UpdateTrainer updateTrainer);
}
