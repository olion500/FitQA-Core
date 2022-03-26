package com.cocovo.fitqaspringjava.domain.user.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import com.cocovo.fitqaspringjava.domain.common.entity.type.ImageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@Table(name = "users_images")
@NoArgsConstructor
public class UserImage extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  private String imageUrl;

  @Enumerated(EnumType.STRING)
  private ImageType.Type imageType;

  @Builder
  public UserImage(User user, String imageUrl, ImageType.Type imageType) {
    //Todo(in.heo): Need to improve exception
    if (StringUtils.isEmpty(imageUrl))
      throw new InvalidParamException("imageUrl is empty");
    this.user = user;
    this.imageUrl = imageUrl;
    this.imageType = imageType;
  }
}
