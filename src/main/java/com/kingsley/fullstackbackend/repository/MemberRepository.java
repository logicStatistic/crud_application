package com.kingsley.fullstackbackend.repository;

import com.kingsley.fullstackbackend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Object> findAllById(Long id);

    List<Object> findById(Member aMember);
}
