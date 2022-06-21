package jpabook.jpashop.repository;

import jpabook.jpashop.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository; // Test에서는 의존성주입할 때 Autowired로 해준다.

    @Test
//    @Transactional // Test에서 트랜잭셔널은 롤백된다.
//    @Rollback(false) // Test에서 롤백을 원치 않을 경우 사용한다.
    void save() {
        //given
        Member member = new Member();
        member.setName("HanKyul");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertEquals(findMember.getId(), savedId);
        Assertions.assertEquals(findMember, member);
    }

    @Test
    void find() {
        Long findId = 1L;
        Member member = memberRepository.find(findId);
        Assertions.assertEquals(findId, member.getId());
    }
}