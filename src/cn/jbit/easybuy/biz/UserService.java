package cn.jbit.easybuy.biz;

import java.util.List;

import cn.jbit.easybuy.entity.Pager;
import cn.jbit.easybuy.entity.User;

public interface UserService {
	void update(User user, String userId);// �����û���Ϣ

	User findById(String userId);// ����ID��ѯ�û���Ϣ

	void save(User user);// �����û���Ϣ

	void addAdress(User user, String address);// Ϊĳ�û���ӵ�ַ

	void delete(String userId);// ����IDɾ���û�

	List<User> getUsers(Pager pager);// ��ѯ��ҳ�û�

	long getUserRowCount();// ��ѯ�û���¼����

	void setLogin(User user, boolean isLogin);// �����û���¼״̬
}
