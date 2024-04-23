package fun.catadopt.cat.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fun.catadopt.cat.entity.UserreplyEntity;
import fun.catadopt.cat.service.UserreplyService;
import fun.catadopt.common.utils.PageUtils;
import fun.catadopt.common.utils.R;



/**
 * VIEW
 *
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 23:30:50
 */
@RestController
@RequestMapping("cat/userreply")
public class UserreplyController {
    @Autowired
    private UserreplyService userreplyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userreplyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userid}")
        public R info(@PathVariable("userid") Integer userid){
		UserreplyEntity userreply = userreplyService.getById(userid);

        return R.ok().put("userreply", userreply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
        public R save(@RequestBody UserreplyEntity userreply){
		userreplyService.save(userreply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
        public R update(@RequestBody UserreplyEntity userreply){
		userreplyService.updateById(userreply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
        public R delete(@RequestBody Integer[] userids){
		userreplyService.removeByIds(Arrays.asList(userids));

        return R.ok();
    }

}
