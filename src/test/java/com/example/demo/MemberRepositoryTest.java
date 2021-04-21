package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Transactional
    @Test
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member foundMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(foundMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(foundMember.getUsername()).isEqualTo(member.getUsername());

        //영속성 컨텍스트에서 같은 오브젝트라고 판단해서
        //select 쿼리 조차 날리지 않는다
        Assertions.assertThat(foundMember).isEqualTo(member);
    }
}