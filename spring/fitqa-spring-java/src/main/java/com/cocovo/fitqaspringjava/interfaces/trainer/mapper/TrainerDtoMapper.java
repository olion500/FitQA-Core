package com.cocovo.fitqaspringjava.interfaces.trainer.mapper;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.interfaces.trainer.dto.TrainerDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TrainerDtoMapper {
  // register
  TrainerCommand.RegisterTrainer of(TrainerDto.RegisterTrainerRequest request);

  TrainerDto.RegisterTrainerResponse of(String trainerToken);

  // retrieve
  TrainerDto.TrainerInfo of(TrainerInfo.Main trainerInfo);
}