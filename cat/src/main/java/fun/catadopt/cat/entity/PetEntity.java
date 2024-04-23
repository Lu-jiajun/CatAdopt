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
@TableName("pet")
public class PetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String petname;
	/**
	 * 宠物类型
	 */
	private String pettype;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 
	 */
	private Date birthday;
	/**
	 * 头像
	 */
	private String pic;
	/**
	 * 现在的状态 0 没有申请领养 1 被申请领养 2 已经被领养
	 */
	private Integer state;
	/**
	 * 备注
	 */
	private String remark;

}
