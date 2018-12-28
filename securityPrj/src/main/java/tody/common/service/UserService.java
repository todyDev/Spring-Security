package tody.common.service;

public interface UserService {

	void countFailure(String username);

	int checkFailureCount(String username);

	void disabledUsername(String username);

	void resetFailureCnt(String username);

}
