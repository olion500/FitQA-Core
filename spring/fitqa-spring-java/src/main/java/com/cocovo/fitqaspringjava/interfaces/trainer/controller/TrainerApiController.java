package com.cocovo.fitqaspringjava.interfaces.trainer.controller;

import com.cocovo.fitqaspringjava.application.feedback.FeedbackFacade;
import com.cocovo.fitqaspringjava.application.trainer.TrainerFacade;
import com.cocovo.fitqaspringjava.common.response.CommonResponse;
import com.cocovo.fitqaspringjava.interfaces.feedback.FeedbackDtoMapper;
import com.cocovo.fitqaspringjava.interfaces.trainer.dto.TrainerDto;
import com.cocovo.fitqaspringjava.interfaces.trainer.mapper.TrainerDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/trainers")
@RequiredArgsConstructor
public class TrainerApiController {

  private final TrainerFacade trainerFacade;
  private final FeedbackFacade feedbackFacade;
  private final TrainerDtoMapper trainerDtoMapper;
  private final FeedbackDtoMapper feedbackDtoMapper;

  @GetMapping
  public CommonResponse getTrainersAll() {
    var trainers = trainerFacade.retrieveTrainers();
    System.out.println(trainers);
    var response =
        trainers.stream().map(main -> trainerDtoMapper.of(main)).collect(Collectors.toList());
    System.out.println(response);
    return CommonResponse.success(response);
  }

  @GetMapping("/{trainerToken}")
  public CommonResponse getTrainerById(@PathVariable("trainerToken") String trainerToken) {
    var trainerInfo = trainerFacade.retrieveTrainerInfo(trainerToken);
    var trainerResponse = trainerDtoMapper.of(trainerInfo);
    return CommonResponse.success(trainerResponse);
  }

  @GetMapping("/{trainerToken}/feedbacks")
  public CommonResponse getTrainerFeedbacks(@PathVariable("trainerToken") String trainerToken) {
    var feedbacks = feedbackFacade.retrieveFeedbacksOfTrainer(trainerToken);
    var response = feedbacks.stream()
        .map(feedbackDtoMapper::of)
        .collect(Collectors.toList());
    return CommonResponse.success(response);
  }

  @GetMapping(params = "interestAreas")
  public CommonResponse getTrainerByInterestAreas(
      @RequestParam(value = "interestAreas", required = true) TrainerDto.RetrieveTrainersRequest request) {
    var trainers = trainerFacade.retrieveTrainers(trainerDtoMapper.of(request));
    var response =
        trainers.stream().map(main -> trainerDtoMapper.of(main)).collect(Collectors.toList());
    return CommonResponse.success(response);
  }

  @PostMapping
  public CommonResponse registerTrainer(
      @RequestBody @Valid TrainerDto.RegisterTrainerRequest request) {
    var registerTrainer = trainerDtoMapper.of(request);
    var trainerToken = trainerFacade.registerTrainer(registerTrainer);
    var response = trainerDtoMapper.of(trainerToken);
    return CommonResponse.success(response);
  }

  @PutMapping("/{trainerToken}/interestAreas")
  public CommonResponse updateTrainerInterestAreas(
      @PathVariable(value = "trainerToken") String trainerToken,
      @RequestBody TrainerDto.UpdateTrainerInterestAreasRequest request) {
    var updatedTrainer =
        trainerFacade.updateTrainerInterestAreas(trainerToken, trainerDtoMapper.of(request));
    var response = trainerDtoMapper.of(updatedTrainer);
    return CommonResponse.success(response);
  }

  @PutMapping("/{trainerToken}")
  public CommonResponse updateTrainerInfo(@PathVariable(value = "trainerToken") String trainerToken,
      @RequestBody @Valid TrainerDto.UpdateTrainerInfoRequest request) {
    var updatedTrainer =
        trainerFacade.updateTrainerInfo(trainerToken, trainerDtoMapper.of(request));
    var response = trainerDtoMapper.of(updatedTrainer);
    return CommonResponse.success(response);
  }
}
