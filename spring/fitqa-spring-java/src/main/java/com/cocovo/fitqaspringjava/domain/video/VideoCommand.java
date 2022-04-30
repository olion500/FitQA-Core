package com.cocovo.fitqaspringjava.domain.video;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class VideoCommand {
    @Getter
    @Builder
    @ToString
    public static class Register {
        private String videoUrl;
        private String thumbnailUrl;
        private int width;
        private int height;
    }
}
