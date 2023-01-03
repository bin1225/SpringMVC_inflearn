package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach(){
		memberRepository.clear();
	}

	@Test
	void save(){
		//given
		Member member = new Member("hello", 20);
		//when
		Member savedMember = memberRepository.save(member);

		//then
		Member findMember = memberRepository.findById(savedMember.getId());
		assertThat(findMember).isEqualTo(savedMember);
	}

	@Test
	void findAll() {
		Member member1 = new Member("member1", 21);
		Member member2 = new Member("member2", 22);

		memberRepository.save(member1);
		memberRepository.save(member2);

		List<Member> result = memberRepository.findAll();

		assertThat(result.size()).isEqualTo(2);
		assertThat(result).contains(member1, member2);
	}
}
