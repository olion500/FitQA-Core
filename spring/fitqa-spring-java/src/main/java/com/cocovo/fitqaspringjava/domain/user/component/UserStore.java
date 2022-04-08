package com.cocovo.fitqaspringjava.domain.user.component;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.user.User;

public interface UserStore {
    User store(User initUser);
}
