package tw.org.iii.cma.labcargojsp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.org.iii.cma.labcargojsp.domain.MemberBean;

public interface MemberRepository extends JpaRepository<MemberBean, Integer> {

	@Query(value = "SELECT account, password FROM member", nativeQuery = true)
	public List<String> findAccount();

	@Query(value = "SELECT MEMBER_NAME FROM member WHERE account =?1" , nativeQuery = true)
	public List<String> findMemberName(String account);
	
	@Query(value = "SELECT * FROM member WHERE account =?1" , nativeQuery = true)
	public MemberBean loginok(String account);


	
	
}