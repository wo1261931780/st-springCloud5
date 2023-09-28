package junw.orderservice.pojo;


import junw.feignapi.pojo.User;
import lombok.Data;

/**
 * @author 64234
 */
@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}
