package tw.org.iii.cma.labcargojsp.Dao;

import tw.org.iii.cma.labcargojsp.domain.CustomerBean;

public interface CustomerDAO {
	public abstract CustomerBean select(String custid);
	public abstract boolean update(byte[] password, String email,
			java.util.Date birth, String custid);
}