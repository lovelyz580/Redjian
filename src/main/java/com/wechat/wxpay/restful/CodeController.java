package com.wechat.wxpay.restful;


import com.wechat.wxpay.entity.Json;
import com.wechat.wxpay.util.GetTokenUtil;
import com.wechat.wxpay.util.QrCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;


/**
 * 获取小程序的二维码
 */
@Controller
@MultipartConfig
@RequestMapping("/create")
public class CodeController {
    /**
     *
     * accessToken 有效时间为2小时，微信每天请求限制调用次数2000次
     * <p>
     * 需要缓存起来，失效了再更新
     * 将access_token保存在redis中  设置2小时失效 删除 在发送请求获取accessToken
     * GetTokenUtil  获取Token 的工具类
     */
    @RequestMapping("/code")
    @ResponseBody
    public Json getminiqrQr(HttpServletRequest request) {
        Json json = new Json();
        String userid = request.getParameter("userid");
        if (userid == null || userid.length() == 0) {
            json.setSuccess(false);
            json.setData("code 不能为空");
            json.setCode(500);
            return json;
        }else {
            System.out.println(userid);
            String accessToken = GetTokenUtil.getAccessToken();//不要轻易调用
            System.out.println(accessToken);  //获取accessToken
            //        生成推广码图片
            String path = QrCodeUtils.CreateCode(request, userid, accessToken);
            json.setData(path);
            json.setSuccess(true);
            json.setCode(200);
            json.setMsg("获取到推广码");
            return json;
        }
    }
}
