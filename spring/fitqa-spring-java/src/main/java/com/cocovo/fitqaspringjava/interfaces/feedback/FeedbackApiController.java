package com.cocovo.fitqaspringjava.interfaces.feedback;

import com.cocovo.fitqaspringjava.application.feedback.FeedbackFacade;
import com.cocovo.fitqaspringjava.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/feedbacks")
@RequiredArgsConstructor
public class FeedbackApiController {
    private final FeedbackFacade feedbackFacade;
    private final FeedbackDtoMapper feedbackDtoMapper;

    @GetMapping
    public CommonResponse<List<FeedbackDto.Main>> getFeedbackAll() {
        var feedbacks = feedbackFacade.retrieveFeedbacks();
        var response = feedbacks.stream()
                .map(feedbackDtoMapper::of)
                .collect(Collectors.toList());
        return CommonResponse.success(response);
    }

    @GetMapping("/{feedbackToken}")
    public CommonResponse<FeedbackDto.Main> getFeedbackById(@PathVariable("feedbackToken") String feedbackToken) {
        var feedbackInfo = feedbackFacade.retrieveFeedbackByToken(feedbackToken);
        var response = feedbackDtoMapper.of(feedbackInfo);
        return CommonResponse.success(response);
    }

    @PostMapping("/register")
    public CommonResponse<FeedbackDto.Main> registerFeedback(@RequestBody @Valid FeedbackDto.RegisterReq request) {
        var registerCommand = feedbackDtoMapper. of(request);
        var feedbackInfo = feedbackFacade.registerFeedback(registerCommand);
        var response = feedbackDtoMapper.of(feedbackInfo);
        return CommonResponse.success(response);
    }
}
