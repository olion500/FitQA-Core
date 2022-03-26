package com.cocovo.fitqaspringjava.domain.trainer;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class TrainerCommand {

  @Getter
  @Builder
  @ToString
  public static class RegisterTrainer {
    private final String name;
    private final WorkOutType.Style style;

    public Trainer toEntity() {
      return Trainer.builder().name(name).style(style).build();
    }
  }
}
