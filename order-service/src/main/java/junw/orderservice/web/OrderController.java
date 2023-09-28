package junw.orderservice.web;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import junw.orderservice.pojo.Order;
import junw.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
	// 每个暴露出去的接口，都是链路中的一部分

	@Autowired
	private OrderService orderService;

	@SentinelResource("hot")
	// 如果不添加，那么这里是一个默认的springMVC资源，热点参数限流是不生效的
	// 同时，热点参数限流只支持java默认类型的。如果不是默认类型，那么不支持
	@GetMapping("{orderId}")
	public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
		// 根据id查询订单并返回
		return orderService.queryOrderById(orderId);
	}
	// 这里已经被监控了，但是service还没有被监控
	// 单机阈值1，就是每秒最多一个请求
	// 超出的部分会直接报错

	// SentinelResource将其标注为一个资源
	

	@GetMapping("/query")
	public String queryOrder() {
		// 查询商品
		orderService.queryGoods();
		// 查询订单
		System.err.println("查询订单");
		return "查询订单成功";
	}
	// 关联限制，根据优先级来判断，query阻塞的时候
	// save也会被阻塞，因为save的优先级比较低
	// 在链路模式中，默认只会监控Controller中的端点
	// service中不会收到影响
	// 而因为没有被监控，所以不会收到限流规则的影响
	// 线程隔离和熔断降级的区别：
	// 线程隔离是为了保护线程，熔断降级是为了保护服务
	// 线程隔离，只将线程隔离起来，不会对服务产生影响
	// 熔断降级会去统计故障服务的比例，如果超过阈值，那么就会熔断




	@GetMapping("/save")
	public String saveOrder() {
		// 查询商品
		orderService.queryGoods();
		// 查询订单
		System.err.println("新增订单");
		return "新增订单成功";
	}

	@GetMapping("/update")
	public String updateOrder() {
		return "更新订单成功";
	}


	// coldFactor表示3，是最大阈值的1/3
	// 流控效果，其实启到的是流量整形的作用
	// 比如我预期要出现一个山峰，但是我设置了等待时间，那么所有的请求都会排队，最终就会变成一个平台
	// 这就是我们常说的削峰
}
