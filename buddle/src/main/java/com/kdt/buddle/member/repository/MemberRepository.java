package com.kdt.buddle.member.repository;

import com.kdt.buddle.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findByAccount(String account);

  boolean existsByAccount(String account);

}
