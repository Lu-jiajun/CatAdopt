package fun.catadopt.cat.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fun.catadopt.cat.entity.AdoptanimalEntity;
import fun.catadopt.cat.service.AdoptanimalService;
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
@RequestMapping("cat/adoptanimal")
public class AdoptanimalController {
    @Autowired
    private AdoptanimalService adoptanimalService;

    /**
     * 列表
     */
    @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = adoptanimalService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Integer id){
		AdoptanimalEntity adoptanimal = adoptanimalService.getById(id);

        return R.ok().put("adoptanimal", adoptanimal);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
        public R save(@RequestBody AdoptanimalEntity adoptanimal){
		adoptanimalService.save(adoptanimal);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
        public R update(@RequestBody AdoptanimalEntity adoptanimal){
		adoptanimalService.updateById(adoptanimal);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
        public R delete(@RequestBody Integer[] ids){
		adoptanimalService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
