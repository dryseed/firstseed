package jp.co.hundsun.mapper;

import jp.co.hundsun.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    User fetchById(Integer id);

}
