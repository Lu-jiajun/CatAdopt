package fun.catadopt.cat.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fun.catadopt.cat.entity.ApplyEntity;
import fun.catadopt.cat.service.ApplyService;
import fun.catadopt.common.utils.PageUtils;
import fun.catadopt.common.utils.R;



/**
 * 
 *
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 23:30:45
 */
@RestController
@RequestMapping("cat/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = applyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Integer id){
		ApplyEntity apply = applyService.getById(id);

        return R.ok().put("apply", apply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
        public R save(@RequestBody ApplyEntity apply){
		applyService.save(apply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
        public R update(@RequestBody ApplyEntity apply){
		applyService.updateById(apply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
        public R delete(@RequestBody Integer[] ids){
		applyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
