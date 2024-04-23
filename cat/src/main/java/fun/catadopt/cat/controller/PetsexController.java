package fun.catadopt.cat.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fun.catadopt.cat.entity.PetsexEntity;
import fun.catadopt.cat.service.PetsexService;
import fun.catadopt.common.utils.PageUtils;
import fun.catadopt.common.utils.R;



/**
 * VIEW
 *
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 23:30:45
 */
@RestController
@RequestMapping("cat/petsex")
public class PetsexController {
    @Autowired
    private PetsexService petsexService;

    /**
     * 列表
     */
    @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = petsexService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{petname}")
        public R info(@PathVariable("petname") String petname){
		PetsexEntity petsex = petsexService.getById(petname);

        return R.ok().put("petsex", petsex);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
        public R save(@RequestBody PetsexEntity petsex){
		petsexService.save(petsex);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
        public R update(@RequestBody PetsexEntity petsex){
		petsexService.updateById(petsex);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
        public R delete(@RequestBody String[] petnames){
		petsexService.removeByIds(Arrays.asList(petnames));

        return R.ok();
    }

}
