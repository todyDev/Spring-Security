package tody.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tody.common.vo.CustomUserDetails;

@Repository("userAuthDAO")
public class UserAuthDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public CustomUserDetails getUserById(String username) {
		return sqlSession.selectOne("user.selectUserById", username);
	}

	public void updateFailureCount(String loginId) {
		sqlSession.update("user.updateFailureCount", loginId);
	}
	
	public int checkFailureCount(String loginId) {
		return sqlSession.selectOne("user.checkFailureCount", loginId);
	}

}
