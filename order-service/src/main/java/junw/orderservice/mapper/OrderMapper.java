package junw.orderservice.mapper;


import junw.orderservice.pojo.Order;
import org.apache.ibatis.annotations.Select;

/**
 * @author 64234
 */
public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
