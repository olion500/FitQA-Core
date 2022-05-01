package com.cocovo.fitqaspringjava.interfaces.video;

import com.cocovo.fitqaspringjava.application.video.VideoFacade;
import com.cocovo.fitqaspringjava.common.response.CommonResponse;
import com.cocovo.fitqaspringjava.domain.video.VideoCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/video")
@RequiredArgsConstructor
public class VideoApiController {

    private final VideoFacade videoFacade;
    private final VideoDtoMapper videoDtoMapper;

    @PostMapping("/{feedbackToken}/waiting/{videoKey}")
    public CommonResponse<VideoDto.VideoWaitingResponse> addWaiting(
            @PathVariable("feedbackToken") String feedbackToken,
            @PathVariable("videoKey") String videoKey) {

        var registerFeedbackWaitingCommand =
                VideoCommand.RegisterFeedbackWaiting.builder()
                        .feedbackToken(feedbackToken)
                        .videoKey(videoKey)
                        .build();

        var waitingInfo = videoFacade.registerFeedbackWaiting(registerFeedbackWaitingCommand);
        var response = videoDtoMapper.of(waitingInfo);
        return CommonResponse.success(response);
    }
}
