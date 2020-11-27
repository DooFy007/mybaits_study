package com.doofy.controller.test;

import com.alibaba.fastjson.JSONObject;
import com.doofy.bean.KafkaMessage;
import com.doofy.bean.TblUser;
import com.doofy.service.KafkaProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "kafka模块")
@RestController
@Slf4j
@RequestMapping("/kafka")
public class KafaController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/publish/{topic}")
    @ApiOperation(value = "发布消息",notes = "发布消息")
    public void publish(@PathVariable String topic, @RequestBody KafkaMessage<TblUser> message){
        kafkaProducerService.publish(topic, JSONObject.toJSONString(message));

    }
}
