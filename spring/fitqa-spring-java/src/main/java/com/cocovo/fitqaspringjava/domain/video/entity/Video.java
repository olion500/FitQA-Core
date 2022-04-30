package com.cocovo.fitqaspringjava.domain.video.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@RequiredArgsConstructor
@Table(name = "videos")
public class Video extends BaseEntity {
    private static final String VIDEO_PREFIX = "vod_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String videoToken;

    private String videoUrl;
    private String thumbnailUrl;

    private int width;
    private int height;

    @Builder
    public Video(String videoUrl, String thumbnailUrl, int width, int height) {
        if (StringUtils.isEmpty(videoUrl))
            throw new InvalidParamException("videoUrl cannot be empty");
        if (StringUtils.isEmpty(thumbnailUrl))
            throw new InvalidParamException("thumbnailUrl cannot be empty");
        if (width < 0) throw new InvalidParamException("width cannot be below 0");
        if (height < 0) throw new InvalidParamException("height cannot be below 0");

        this.videoToken = TokenGenerator.randomCharacterWithPrefix(VIDEO_PREFIX);
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.width = width;
        this.height = height;
    }
}
