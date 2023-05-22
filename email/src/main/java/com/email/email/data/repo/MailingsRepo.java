package com.email.email.data.repo;

import com.email.email.data.model.Mailings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface MailingsRepo extends JpaRepository<Mailings, Long> {
}
