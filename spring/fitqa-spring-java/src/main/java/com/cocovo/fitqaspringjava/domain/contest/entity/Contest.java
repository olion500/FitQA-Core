package com.cocovo.fitqaspringjava.domain.contest.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
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
@Table(name = "contests")
@RequiredArgsConstructor
public class Contest extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String contestName;
  private int hostYear;

  @Builder
  public Contest(String contestName, int hostYear) {
    if (StringUtils.isEmpty(contestName))
      throw new InvalidParamException("contestName is empty");
    this.contestName = contestName;
    this.hostYear = hostYear;
  }
}
