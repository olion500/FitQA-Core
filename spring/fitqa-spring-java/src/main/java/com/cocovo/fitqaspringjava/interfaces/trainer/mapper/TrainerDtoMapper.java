package com.cocovo.fitqaspringjava.interfaces.trainer.mapper;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.interfaces.trainer.dto.TrainerDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TrainerDtoMapper {
  // register
  TrainerCommand.RegisterTrainer of(TrainerDto.RegisterTrainerRequest request);

  TrainerCommand.RetrieveTrainersByInterestAreas of(TrainerDto.RetrieveTrainersRequest request);

  TrainerDto.RegisterTrainerResponse of(String trainerToken);

  TrainerDto.Main of(TrainerInfo.Main trainerInfo);

  TrainerDto.TrainerImageInfo of(TrainerInfo.TrainerImageInfo trainerImageInfo);

  TrainerDto.TrainerCareerInfo of(TrainerInfo.TrainerCareerInfo trainerCareerInfo);

  TrainerDto.TrainerFeedbackPriceInfo of(
      TrainerInfo.TrainerFeedbackPriceInfo trainerFeedbackPriceInfo);

  TrainerDto.TrainerInterestAreaInfo of(
      TrainerInfo.TrainerInterestAreaInfo trainerInterestAreaInfo);

  TrainerDto.TrainerSnsInfo of(TrainerInfo.TrainerSnsInfo trainerSnsInfo);

  // update
  TrainerCommand.UpdateTrainersByInterestAreas of(TrainerDto.UpdateTrainerInterestAreasRequest request);
}