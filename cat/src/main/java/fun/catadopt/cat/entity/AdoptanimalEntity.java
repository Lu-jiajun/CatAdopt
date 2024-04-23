package fun.catadopt.cat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 00:35:50
 */
@Data
@TableName("adoptanimal")
public class AdoptanimalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户表id的外键
	 */
	private Integer userid;
	/**
	 * 宠物表id的外键
	 */
	private Integer petid;
	/**
	 * 
	 */
	private Date adopttime;
	/**
	 * 是否同意被领养 0 是不同意 1 还在审核 2 是同意
	 */
	private Integer state;

}
