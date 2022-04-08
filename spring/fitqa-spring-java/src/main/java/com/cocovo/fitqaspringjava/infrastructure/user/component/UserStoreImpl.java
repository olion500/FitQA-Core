package com.cocovo.fitqaspringjava.infrastructure.user.component;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.user.User;
import com.cocovo.fitqaspringjava.domain.user.component.UserStore;
import com.cocovo.fitqaspringjava.infrastructure.feedback.repository.FeedbackRepository;
import com.cocovo.fitqaspringjava.infrastructure.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {
    private final UserRepository userRepository;
    @Override
    public User store(User initUser) {
        return userRepository.save(initUser);
    }
}
