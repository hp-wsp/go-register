package com.ts.server.mask.controller.client;

import com.ts.server.mask.BaseException;
import com.ts.server.mask.common.utils.IDCardUtils;
import com.ts.server.mask.controller.client.form.GoRegisterForm;
import com.ts.server.mask.controller.vo.HasVo;
import com.ts.server.mask.controller.vo.ResultVo;
import com.ts.server.mask.domain.GoRegister;
import com.ts.server.mask.service.GoRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * 外出登记API
 *
 * @author TS Group
 */
@RestController
@RequestMapping("/client/register")
@Api(value = "/client/register", tags = "C-外出登记API")
public class RegisterClientController {

    private final GoRegisterService service;

    @Autowired
    public RegisterClientController(GoRegisterService service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation("登记")
    public ResultVo<GoRegister> register(@Valid @RequestBody GoRegisterForm form){
        if(!IDCardUtils.validate(form.getIdCard())){
            throw new BaseException(415, "身份证号不正确");
        }
        GoRegister t = form.toDomain();
//        if(StringUtils.isNotBlank(t.getProvince()) && StringUtils.isNotBlank(t.getCouAddress())){
//            throw new BaseException("本县、外省务工目的地只能填写一个");
//        }
//        if(StringUtils.isBlank(t.getProvince()) && StringUtils.isBlank(t.getCouAddress())){
//            throw new BaseException("请选择务工目的地");
//        }
//        if(StringUtils.isNotBlank(t.getCouAddress())){
//            t.setProvince("");
//            t.setCity("");
//            t.setGoDate("");
//        }else{
//            if(StringUtils.isBlank(t.getProvince()) || StringUtils.isBlank(t.getCity()) || StringUtils.isBlank(t.getGoDate())){
//                throw new BaseException("外出省份、外出城市、外出日期必填");
//            }
//        }

        return ResultVo.success(service.save(t));
    }

    @GetMapping(value = "{idCard}", produces = APPLICATION_JSON_VALUE)
    public ResultVo<HasVo> get(@PathVariable("idCard")String idCard){
        return ResultVo.success(service.get(idCard).map(e-> HasVo.hasData(true, e)).orElse(HasVo.noneData(false)));
    }

}
