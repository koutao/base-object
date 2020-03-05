package com.koutao.baseobject.modules.demo.controller;

import com.koutao.baseobject.config.model.CustomException;
import com.koutao.baseobject.config.model.EnumCustomExceptionType;
import com.koutao.baseobject.config.model.ResultModel;
import io.swagger.annotations.*;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@Api(tags = "AppGoodsNumSyncController|商品数量同步控制器")
@RestController
@RequestMapping("/app/goods")
public class AppGoodsNumSyncController {

    @PostMapping("/timing/sync")
    @ApiOperation(value = "定时同步商品数", notes = "定时同步商品数")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "token", value = "devId", dataType = "string", required = true),
            @ApiImplicitParam(paramType = "header", name = "devId", value = "设备唯一编号", dataType = "string",required = true),
            @ApiImplicitParam(paramType = "body", name = "jsonParam", value = "JSON格式参数", examples = @Example({
                    @ExampleProperty(mediaType = "cargowayList", value = "[{\"cargowayNo\": \"货道1\", \"goodsNumber\": 20, \"goodsId\": \"1\"}]")
            }), required = true, dataType = "string")
    })
    public ResultModel<JSONObject> timingSync(@RequestBody JSONObject jsonParam, @RequestHeader("devId")String devId) {
        return new ResultModel("swagger 测试");
    }

    @PostMapping("/replenishment/sync")
    @ApiOperation(value = "补货后同步商品数", notes = "补货后同步商品数")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "token", value = "devId", dataType = "string",required = true),
            @ApiImplicitParam(paramType = "header", name = "devId", value = "设备唯一编号", dataType = "string",required = true),
            @ApiImplicitParam(paramType = "body", name = "jsonParam", value = "JSON格式参数", examples = @Example({
                    @ExampleProperty(mediaType = "oldCargowayList", value = " [{\"cargowayNo\": \"货道1\", \"goodsNumber\": 20, \"goodsId\": \"1\"}]"),
                    @ExampleProperty(mediaType = "newCargowayList", value = " [{\"cargowayNo\": \"货道1\", \"goodsNumber\": 20, \"goodsId\": \"1\"}]")
            }), required = true, dataType = "string")
    })
    public ResultModel replenishmentSync(@RequestBody JSONObject jsonParam, @RequestHeader("devId")String devId) {
        throw new CustomException(EnumCustomExceptionType.EXCEPTION_NO_CATCH_TYPE);
    }
}
