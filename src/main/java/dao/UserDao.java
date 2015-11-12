package dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import entity.User;

public interface UserDao {
	
	@Select("select * from user where userid=#{userid}")
    public User select(@Param("userid")int userid);
    
	/**
	 * 插入数据, 将本次插入的主键保存入参数user中
	 * @param user
	 * @return 数据变更数量
	 */
	@Insert("insert into user (username, password) values (#{user.username}, #{user.password})")
	@SelectKey(keyProperty="user.userid",statement="SELECT LAST_INSERT_ID()", before=false, resultType=Integer.class)  
	public int insert(@Param("user")User user);
    
	@Delete("delete from user where userid=#{userid}")
    public int delete(@Param("userid")int userid);
    
	@Update("update user set username=#{user.username},password=#{user.password} where userid=#{user.userid}")
    public int update(@Param("user")User user);

} 