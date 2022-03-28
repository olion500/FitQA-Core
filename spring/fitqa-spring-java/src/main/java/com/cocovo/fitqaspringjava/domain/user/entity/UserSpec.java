package com.cocovo.fitqaspringjava.domain.user.entity;

import com.cocovo.fitqaspringjava.domain.BaseEntity;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "users_spec")
public class UserSpec extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Enumerated(EnumType.STRING)
  private WorkOutLevel workOutLevel;

  @Enumerated(EnumType.STRING)
  private WorkOutType.Style workOutStyle;

  private Float bodyFatPercentage;
  private Float muscleMass;

  @RequiredArgsConstructor
  public enum WorkOutLevel {
    BEGINNER("초보자"), INTERMEDIATE("중급자"), ADVANCED("상급자"), SKILLED("숙련자");

    private final String description;
  }

  @Builder
  public UserSpec(User user, Float bodyFatPercentage, Float muscleMass,
                  WorkOutType.Style workOutStyle, WorkOutLevel workOutLevel) {
    this.user = user;
    this.bodyFatPercentage = bodyFatPercentage;
    this.muscleMass = muscleMass;
    this.workOutStyle = workOutStyle;
    this.workOutLevel = workOutLevel;
  }
}
