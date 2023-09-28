package junw.feignapi.clients.fallback;


import feign.hystrix.FallbackFactory;
import junw.feignapi.clients.UserClient;
import junw.feignapi.pojo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 64234
 */
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
	@Override
	public UserClient create(Throwable throwable) {
		return new UserClient() {
			@Override
			public User findById(Long id) {
				log.error("查询用户异常", throwable);
				return new User();
				// 直接返回一个空的用户对象，避免出现错误
			}
		};
	}
	// 这里是可以获取异常信息的
	// 因为实现了对应的接口，所以这里需要进行一遍重写操作

}
