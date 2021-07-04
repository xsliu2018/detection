package top.xsliu.detection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.xsliu.detection.annotation.ExceptionPoint;
import top.xsliu.detection.entity.Bridge;
import top.xsliu.detection.entity.User;
import top.xsliu.detection.model.query.BridgeParams;
import top.xsliu.detection.model.result.PageResult;
import top.xsliu.detection.model.result.Result;
import top.xsliu.detection.service.BridgeService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/3:15 下午
 */
@Controller
@RequestMapping("/common")
public class BridgeController {

    @Resource
    private BridgeService bridgeService;

    @ExceptionPoint
    @GetMapping("/bridge/list")
    @ResponseBody
    public PageResult<Bridge> listAllBridge( HttpSession session, @RequestParam(required = false) String keyword){
        User user = (User) session.getAttribute("user");
        BridgeParams params = new BridgeParams();
        params.setUserId(user.getId());
        // 前端分页
        params.setPage(false);
        params.setKeyword(keyword);
        // 状态不为0
        params.set_status(0);
        List<Bridge> bridges = bridgeService.queryBridgesByParams(params);
        return PageResult.ofSuccess(bridges, bridgeService.countBridgesByParams(params));
    }

    @ExceptionPoint
    @GetMapping("/bridges")
    public String list(HttpServletRequest request){
        request.setAttribute("path", "bridges");
        return "admin/bridge";
    }

    @ExceptionPoint
    @PostMapping("/bridge/delete")
    @ResponseBody
    public Result<?> deleteBridges(@RequestBody List<Long> ids){
        if (ids == null || ids.size() == 0){
            return Result.success();
        }
        return Result.success(bridgeService.batchDeleteBridges(ids));
    }

}
