package com.ts.server.mask.controller.manage;

import com.ts.server.mask.BaseException;
import com.ts.server.mask.common.excel.ExcelWriter;
import com.ts.server.mask.controller.manage.excel.GoRegisterExcelWriter;
import com.ts.server.mask.controller.vo.HasVo;
import com.ts.server.mask.controller.vo.ResultPageVo;
import com.ts.server.mask.controller.vo.ResultVo;
import com.ts.server.mask.domain.GoRegister;
import com.ts.server.mask.service.GoRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * 外出登记管理
 *
 * @author TS Group
 */
@RestController
@RequestMapping("/man/register")
@Api(value = "/man/register", tags = "M-外出登记管理")
public class RegisterManController {
    private final GoRegisterService service;

    @Autowired
    public RegisterManController(GoRegisterService service) {
        this.service = service;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation("查询外出登记")
    public ResultPageVo<GoRegister> query(
            @ApiParam(value = "姓名") @RequestParam(required = false) String name,
            @ApiParam(value = "乡镇") @RequestParam(required = false) String area,
            @RequestParam(defaultValue = "true")@ApiParam(value = "是否得到查询记录数") boolean isCount,
            @RequestParam(defaultValue = "0") @ApiParam(value = "查询页数") int page,
            @RequestParam(defaultValue = "15") @ApiParam(value = "查询每页记录数") int rows){


        return new ResultPageVo.Builder<>(page, rows, service.query(name, area, page * rows, rows))
                .count(isCount, () -> service.count(name, area))
                .build();
    }

    @GetMapping(value = "export")
    @ApiOperation("导出外出登记")
    public void exportExcel(@ApiParam(value = "乡镇") @RequestParam(required = false) String area, HttpServletResponse response){

        try(ExcelWriter<GoRegister> writer = new GoRegisterExcelWriter(response, false, "登记表");){
            final int row = 500;
            for(int i = 0; i < 200; i++){
                int offset = row * i;
                List<GoRegister> data = service.query("", area, offset, row);
                if(data.isEmpty()){
                    break;
                }
                writer.write(offset, data);
            }
        }catch (IOException e){
            throw new BaseException("导出登记信息错误");
        }
    }
}
