package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository=new MemoryMemberRepository();
    //test가 끝날 때 마다 저장소 비우는 함수 AfterEach
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //Member result=repository.findById(member.getId()).get();
        //way 1 : System.out.println("result = " + (result==member));
        //way 2 : Assertions.assertEquals(result,member);
        //way 3 : assertThat(member).isEqualTo(null);
    }
        @Test
        public void findByName(){
            Member member1=new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2=new Member();
            member2.setName("spring2");
            repository.save(member2);

            Member result=repository.findByName("spring1").get();
            assertThat(result).isEqualTo(member1);
        }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result=repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
