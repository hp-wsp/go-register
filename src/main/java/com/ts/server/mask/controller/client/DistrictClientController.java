package com.ts.server.mask.controller.client;

import com.ts.server.mask.controller.client.vo.DistrictVo;
import com.ts.server.mask.controller.vo.ResultVo;
import com.ts.server.mask.service.DistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * 行政区划API接口
 *
 * @author <a href="mailto:hhywangwei@gmail.com">WangWei</a>
 */
@RestController
@RequestMapping("/client/district")
@Api(value = "/client/district", tags = "C-行政区划API接口")
public class DistrictClientController {
    private final DistrictService service;

    @Autowired
    public DistrictClientController(DistrictService service) {
        this.service = service;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation("查询行政区划")
    public ResultVo<Collection<DistrictVo>> query(@RequestParam(value = "id", required = false, defaultValue = "root") String id){
        return ResultVo.success(service.query(id).stream().map(DistrictVo::new).collect(Collectors.toList()));
    }
}
