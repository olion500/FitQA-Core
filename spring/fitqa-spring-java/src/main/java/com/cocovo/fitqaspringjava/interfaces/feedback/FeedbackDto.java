package com.cocovo.fitqaspringjava.interfaces.feedback;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
public class FeedbackDto {
    @NotEmpty(message = "title 은 필수값입니다.")
    private String title;
    @NotEmpty(message = "content 는 필수값입니다.")
    private String content;
    @NotNull(message = "locked 는 필수값입니다.")
    private boolean locked;
}
