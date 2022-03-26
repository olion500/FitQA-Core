package com.cocovo.fitqaspringjava.domain.like.entity;

import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@NoArgsConstructor
@Entity
@Table(name = "likes")
public class Like extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;
  private Long trainerId;

  @Builder
  public Like(Long userId, Long trainerId) {
    this.userId = userId;
    this.trainerId = trainerId;
  }
}
