package com.cocovo.fitqaspringjava.domain.trainer.entity;

import com.cocovo.fitqaspringjava.domain.BaseEntity;
import com.cocovo.fitqaspringjava.domain.common.entity.type.SnsType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@Table(name = "trainers_sns")
@RequiredArgsConstructor
public class TrainerSns extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "trainer_id")
  private Trainer trainer;


  @Enumerated(EnumType.STRING)
  private SnsType.Type snsType;
  private String snsUrl;

  @Builder
  public TrainerSns(Trainer trainer, SnsType.Type snsType, String snsUrl) {
    this.trainer = trainer;
    this.snsType = snsType;
    this.snsUrl = snsUrl;
  }
}
