package com.cocovo.fitqaspringjava.interfaces.feedback;

import com.cocovo.fitqaspringjava.application.feedback.FeedbackFacade;
import com.cocovo.fitqaspringjava.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public CommonResponse<List<FeedbackDto>> getFeedbackAll() {
        var feedbacks = feedbackFacade.retrieveFeedbacks();
        var response = feedbacks.stream()
                .map(feedbackDtoMapper::of)
                .collect(Collectors.toList());
        return CommonResponse.success(response);
    }

    @GetMapping("/{feedbackToken}")
    public CommonResponse<FeedbackDto> getFeedbackById(@PathVariable("feedbackToken") String feedbackToken) {
        var feedbackInfo = feedbackFacade.retrieveFeedbackByToken(feedbackToken);
        var response = feedbackDtoMapper.of(feedbackInfo);
        return CommonResponse.success(response);
    }
}
