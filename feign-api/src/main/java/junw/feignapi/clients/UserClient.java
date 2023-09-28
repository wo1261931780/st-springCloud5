package junw.feignapi.clients;


import junw.feignapi.clients.fallback.UserClientFallbackFactory;
import junw.feignapi.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 64234
 */
@FeignClient(value = "userservice", fallbackFactory = UserClientFallbackFactory.class)
// 然后我们使用字节码去进行调用
public interface UserClient {

	@GetMapping("/user/{id}")
	User findById(@PathVariable("id") Long id);
	// 订单服务远程调用了用户服务
}
