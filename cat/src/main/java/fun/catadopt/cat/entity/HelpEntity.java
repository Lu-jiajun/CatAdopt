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
@TableName("help")
public class HelpEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer userid;
	/**
	 * 
	 */
	private Integer adminsid;
	/**
	 * 
	 */
	private Integer petid;
	/**
	 * 
	 */
	private Date commenttime;
	/**
	 * 评论的内容
	 */
	private String content;
	/**
	 * 
	 */
	private Integer state;

}
