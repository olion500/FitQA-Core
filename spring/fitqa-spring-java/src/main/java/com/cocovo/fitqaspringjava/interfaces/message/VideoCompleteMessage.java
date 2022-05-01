package com.cocovo.fitqaspringjava.interfaces.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class VideoCompleteMessage {
    private Status status;
    private Date time;
    private String key;
    private List<VideoCompleteFile> files;

    @Getter
    @ToString
    @EqualsAndHashCode
    static class VideoCompleteFile {
        private FileType type;
        private String url;
        private int width;
        private int height;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        SUCCESS("성공"),
        ERROR("에러");

        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum FileType {
        @JsonProperty("video")
        VIDEO("비디오"),
        @JsonProperty("image")
        IMAGE("썸네일");

        private final String description;
    }
}

