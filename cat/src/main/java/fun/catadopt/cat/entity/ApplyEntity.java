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
@TableName("apply")
public class ApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private Integer age;
	/**
	 * 
	 */
	private String telephone;
	/**
	 * 
	 */
	private String message;
	/**
	 * 
	 */
	private Date applytime;
	/**
	 * 
	 */
	private Integer state;

}
