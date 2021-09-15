package tw.org.iii.cma.labcargojsp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.org.iii.cma.labcargojsp.Dao.MemberRepository;
import tw.org.iii.cma.labcargojsp.Dao.OderdetailRepository;
import tw.org.iii.cma.labcargojsp.domain.MemberBean;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private OderdetailRepository oderdetailRepository;
	
	public List<MemberBean> select(MemberBean bean) {
		List<MemberBean> result = null;
		if (bean != null && bean.getMemberNo() != null && !bean.getMemberNo().equals(0)) {
			Optional<MemberBean> temp = memberRepository.findById(bean.getMemberNo());
			if (temp.isPresent()) {
				result = new ArrayList<MemberBean>();
				result.add(temp.get());
			}
		} else {
			result = memberRepository.findAll();
		}
		return result;
	}

	public Object insert(String account, String password, String memberName, String phone, String address) {
		if (account != null) {
			MemberBean member = new MemberBean();
			member.setMemberName(memberName);
			member.setAccount(account);
			member.setAddress(address);
			member.setPassword(password);
			member.setPhone(phone);
			memberRepository.save(member);

		}
		return account + password + memberName + phone + address;
	}

	public MemberBean login(MemberBean bean) {

		List<String> account = memberRepository.findAccount();
		String bean2 = bean.getAccount() + "," + bean.getPassword();

		if (bean != null && bean.getAccount().length() != 0 && bean.getPassword().length() != 0) {
			if (account.contains(bean2)) {

				return bean;
			}
			return null;
		}
		return null;
	}

	public MemberBean loginok(MemberBean bean) {
		MemberBean bean2 = memberRepository.loginok(bean.getAccount());

		return bean2;
	}
	public int getLevel(MemberBean bean) {
		MemberBean bean2 = memberRepository.loginok(bean.getAccount());
		String bean3 =bean2.getMemberName();

	
		return oderdetailRepository.findLevel(bean3);
	}
}
