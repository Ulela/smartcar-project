package com.smart.car.record.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.record.entity.RecordChargeRule;
import com.smart.car.record.service.RuleService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计费规则控制
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@RestController
@RequestMapping("chargingRule")
@AllArgsConstructor
public class RecordChargeRuleController {
    private final RuleService ruleService;
    /**
     * 查询规则列表(不使用缓存示例)
     */
    @GetMapping("/list")
    public ResponseResult<List<RecordChargeRule>> list(){
        List<RecordChargeRule> list = ruleService.list();
        return ResponseResult.ok(list);
    }

    private Map<String, Object> cache = new HashMap<>();
    /**
     * 查询规则列表(使用本地缓存示例)
     * @author zoutao.blog.csdn.net
     */
    @GetMapping("/cacheList")
    public ResponseResult<List<RecordChargeRule>> listLocal(){
        List<RecordChargeRule> ruleCache = (List<RecordChargeRule>) cache.get("ruleList");
        // 如果缓存中没有，则先从数据库中获取
        if (ruleCache == null) {
            System.out.println("缓存为空");
            // 从数据库中查询数据
            List<RecordChargeRule> list = ruleService.list();
            // 将数据放入缓存中
            ruleCache = list;
            cache.put("ruleList", list);
        }
        System.out.println("缓存的值是：》》》》》》》》》》》》"+cache.get("ruleList"));
        return ResponseResult.ok(ruleCache);
    }

    private final StringRedisTemplate stringRedisTemplate;
    /**
     * 查询规则列表(使用redis缓存示例)
     * @author zoutao.blog.csdn.net
     */
    @GetMapping("listByRedis")
    public List<RecordChargeRule> listRedis() {
        // 1.初始化 redis 组件
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        // 2.从缓存中查询数据
        String ruleList = ops.get("ruleList");
        // 3.如果缓存中没有数据
        if (StringUtils.isEmpty(ruleList)) {
            System.out.println("The cache is empty");
            // 4.从数据库中查询数据
            List<RecordChargeRule> DbList = ruleService.list();
            // 5.将从数据库中查询出的数据序列化 JSON 字符串
            ruleList = JSON.toJSONString(DbList);
            // 6.将序列化后的数据存入缓存中
            ops.set("ruleList", ruleList);
            return DbList;
        }
        // 7.如果缓存中有数据，则从缓存中拿出来，并反序列化为实例对象
        List<RecordChargeRule> entityList = JSON.parseObject(ruleList, new TypeReference<List<RecordChargeRule>>(){});
        return entityList;
    }

    @GetMapping("refresh")
    public ResponseResult<Void> refresh() {
        ruleService.refresh();
        return ResponseResult.ok();
    }
}
