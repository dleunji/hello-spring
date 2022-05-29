package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스는 다중상속이 가능
// JPARepository를 상속하면 자동으로 Bean 등록
// 인터페이스만으로 구현 완료 가능
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // JPQL select m from Member m where m.name = ?
    // 자동으로 이름을 기준으로 SELECT
    // 조합으로 하기 힘든 쿼리는 JdbcTemplate을 이용
    @Override
    Optional<Member> findByName(String name);
}
