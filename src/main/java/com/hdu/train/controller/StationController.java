package com.hdu.train.controller;

import com.hdu.train.service.StationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:56 18-1-7
 * @Modified By:
 */
@Controller
@RequestMapping("/station")
public class StationController {
    @Resource
    private StationService stationService;

    @RequestMapping("/option")
    public
    @ResponseBody
    Map<String, Object> getAllStation() {
        Map<String, Object> modeMap = new HashMap<>();
        List<String> stations = stationService.getAllStation();
        modeMap.put("data", stations);
        return modeMap;
    }
}
