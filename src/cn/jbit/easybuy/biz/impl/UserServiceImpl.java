package cn.jbit.easybuy.biz.impl;

import java.sql.Connection;
import java.util.List;

import cn.jbit.easybuy.biz.UserService;
import cn.jbit.easybuy.entity.Pager;
import cn.jbit.easybuy.entity.User;

public class UserServiceImpl implements UserService {

	@Override
	public void update(User user, String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(String userId) {
		// TODO 根据ID查找用户信息
		Connection connection = null;
		User user = null;
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAdress(User user, String address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUserRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLogin(User user, boolean isLogin) {
		// TODO Auto-generated method stub

	}

}
