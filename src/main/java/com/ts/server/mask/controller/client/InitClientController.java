package com.ts.server.mask.controller.client;

import com.ts.server.mask.config.GoProperties;
import com.ts.server.mask.controller.client.vo.InitVo;
import com.ts.server.mask.controller.vo.ResultVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * 行政区划API接口
 *
 * @author <a href="mailto:hhywangwei@gmail.com">WangWei</a>
 */
@RestController
@RequestMapping("/client/init")
@Api(value = "/client/init", tags = "C-行政区划API接口")
public class InitClientController {
    private final GoProperties goProperties;

    @Autowired
    public InitClientController(GoProperties goProperties) {
        this.goProperties = goProperties;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResultVo<InitVo> get(){
        return ResultVo.success(new InitVo(goProperties.getNotice(), goProperties.getGoDates()));
    }
}
