package top.xsliu.detection.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.xsliu.detection.dao.BridgeMapper;
import top.xsliu.detection.model.result.PageResult;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/1/10:50 下午
 */
@RestController
public class TestController {

    @Resource
    private BridgeMapper mapper;

    @GetMapping("/test")
    public void test(@RequestParam Long id){
        mapper.queryBridgeById(id);
    }

    @GetMapping("/test/data")
    @ResponseBody
    public Object testData(){
        List<Data> data = new ArrayList<>();
        for (int i = 0; i < 10; i ++){
            data.add(new Data(i, i+11));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", 100);
        jsonObject.put("rows", data);
        return jsonObject;
    }

    @lombok.Data
    @AllArgsConstructor
    static class Data{
        private int id;
        private int name;
    }
}
