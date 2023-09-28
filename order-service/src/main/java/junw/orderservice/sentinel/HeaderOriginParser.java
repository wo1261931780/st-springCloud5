package junw.orderservice.sentinel;


import com.alibaba.cloud.commons.lang.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author 64234
 */
@Component
public class HeaderOriginParser {
	// 如果没有自己实现接口，那么结果永远都是default
//public class HeaderOriginParser implements RequestOriginParser {
//	@Override
//	public String parseOrigin(HttpServletRequest request) {
//		// 1.获取请求头
//		String origin = request.getHeader("origin");
// 	请求头在yml中配置，可以自定义
// 	完成以后，在sentinal中设置即可
//		// 2.非空判断
//		if (StringUtils.isEmpty(origin)) {
//			origin = "blank";
//		}
//		return origin;
//	}
}
