package com.cocovo.fitqaspringjava.interfaces.trainer.controller;

import com.cocovo.fitqaspringjava.application.trainer.TrainerFacade;
import com.cocovo.fitqaspringjava.common.response.CommonResponse;
import com.cocovo.fitqaspringjava.interfaces.trainer.dto.TrainerDto;
import com.cocovo.fitqaspringjava.interfaces.trainer.mapper.TrainerDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/trainers")
@RequiredArgsConstructor
public class TrainerApiController {
  private final TrainerFacade trainerFacade;
  private final TrainerDtoMapper trainerDtoMapper;

  @PostMapping
  public CommonResponse registerTrainer(
      @RequestBody @Valid TrainerDto.RegisterTrainerRequest request) {
    var registerTrainer = trainerDtoMapper.of(request);
    var trainerToken = trainerFacade.registerTrainer(registerTrainer);
    var response = trainerDtoMapper.of(trainerToken);
    return CommonResponse.success(response);
  }

  @GetMapping("/{trainerToken}")
  public CommonResponse getTrainerById(@PathVariable("trainerToken") String trainerToken) {
    var trainerInfo = trainerFacade.retrieveTrainerInfo(trainerToken);
    var trainerResponse = trainerDtoMapper.of(trainerInfo);
    return CommonResponse.success(trainerResponse);
  }
}
