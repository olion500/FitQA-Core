package com.cocovo.fitqaspringjava.domain.video;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class VideoInfo {
    @Getter
    @Builder
    @ToString
    public static class Main {
        private String videoUrl;
        private String thumbnailUrl;
        private int width;
        private int height;
    }
}
