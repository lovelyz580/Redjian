package com.wechat.bus.restful;

import com.wechat.bus.entity.Memorandum;
import com.wechat.bus.service.MemorandumService;
import com.wechat.util.Config;
import com.wechat.util.LayuiDataTemplet;
import com.wechat.util.VersionCompare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * Created by Lovelyz
 * on 2019-04-04 14:03
 */
@Controller
@RequestMapping("/memorandum")
public class H_MemorandumRestful {
    @Autowired
    private MemorandumService memorandumService;
    /**
     * 根据Memorandum实体添加
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByMemorandum")
    public LayuiDataTemplet<Memorandum> insertByMemorandum(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不能为空，验证版本号
        try {
            if (null != memorandum.getVersion() && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        //判断登录名不能重复
        Memorandum memorandumSelectData = new Memorandum();
        memorandumSelectData.setmName("123");//登录名
        Memorandum memorandumone = memorandumService.selectByMemorandumone(memorandumSelectData); // 查询数据
        if (memorandumone.getmId() !=null) {
            returnData.setMsg("该用户已注册、请登录！");
            return returnData;
        }
        // 添加数据
        memorandum.setmName("images");//未知 男女
        memorandum.setmId(UUID.randomUUID().toString());
        memorandum.setmUid("1");
        // 添加
        int count = 0;
        count = memorandumService.insertByMemorandum(memorandum);
        // 返回数据
        if (count == 0) {
            returnData.setMsg("添加失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("添加成功！");
        }
        return returnData;
    }

    /**
     * 根据Memorandum实体更新
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByMemorandum")
    public LayuiDataTemplet<Memorandum> updateByMemorandum(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (memorandum.getVersion() != null && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 更新判断
        memorandum.setmId("213");
        if (memorandum.getmId() == null || memorandum.getmId() == "") {
            if (memorandum.getmId() == null || memorandum.getmId().isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }
        // 更新数据
        //MD5加密MD5Util.encrypt(memorandum.getmemorandumpassword();
        // 更新时间
        memorandum.setmContent("我正在更新");
        // 更新
        int count = 0;
        count = memorandumService.updateByMemorandum(memorandum);
        // 返回数据
        if (count == 0) {
            returnData.setMsg("更新失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("更新成功！");
        }
        return returnData;
    }

    /**
     * 根据Memorandum实体查询 单条数据
     * @param memorandum  单条数据
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByMemorandumid")
    public LayuiDataTemplet<Memorandum> selectByMemorandumid(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (memorandum.getVersion() != null && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        memorandum.setmId("213");
        Memorandum memorandumone = memorandumService.selectByMemorandumone(memorandum); // 查询数据
        if (memorandumone!=null){
            returnData.setCount(1);
            returnData.setOnedata(memorandumone);
        }else {
            returnData.setCount(0);
          returnData.setMsg("暂无数据");
        }

        return returnData;
    }
    /**
     * 根据Memorandum实体联表查询 多条数据
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByMemorandumlist")
    public LayuiDataTemplet<Memorandum> selectByMemorandumlist(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (memorandum.getVersion() != null && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 分页数据
        // 使用limit分页查询，根据偏移量查询
        // 第一个参数为第一个返回记录行的偏移量，第二个参数为返回记录行的最大数目
        // MySQL > SELECT * FROM table LIMIT 5, 10; // 查询第6-15行数据
        if (memorandum.getPagenumber() != null) {
            // 计算偏移量
            if (memorandum.getPagenumber() != -1) {
                if (memorandum.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }
                // 获取传递过来的数据
                int pageNumber = memorandum.getPagenumber();
                int pageSize = memorandum.getPagesize();
                memorandum.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                memorandum.setPagesize(pageSize); // 每页的数据量
            }
            // 查询数量
            int count = 0;
            count = memorandumService.selectCountByMemorandum(memorandum);
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCode(200);
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Memorandum> memorandumList = memorandumService.selectByMemorandumList(memorandum); // 查询数据
                returnData.setData(memorandumList);
            }
        } else {
            returnData.setCode(500);
            returnData.setMsg("传递的分页数据(页数)错误！");
        }
        return returnData;
    }
    /**
     * 根据Memorandum实体联表模糊查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<Memorandum> selectBySelectData(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (memorandum.getVersion() != null && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 分页数据
        // 使用limit分页查询，根据偏移量查询
        // 第一个参数为第一个返回记录行的偏移量，第二个参数为返回记录行的最大数目
        // MySQL > SELECT * FROM table LIMIT 5, 10; // 查询第6-15行数据
        if (memorandum.getPagenumber() != null) {
            // 计算偏移量
            if (memorandum.getPagenumber() != -1) {
                if (memorandum.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = memorandum.getPagenumber();
                int pageSize = memorandum.getPagesize();
                memorandum.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                memorandum.setPagesize(pageSize); // 每页的数据量
            }
            // 查询数量
            int count = 0;
            count = memorandumService.selectCountBySelectData(memorandum); // 查询数量
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Memorandum> memorandum1List = memorandumService.selectBySelectData(memorandum); // 查询数据
                returnData.setData(memorandum1List);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }
        return returnData;
    }
    /**
     * 根据Memorandum实体删除信息(假删，更改状态)(0:删除、1：未删除)
     * @param memorandum 单条删除
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByMemorandumDel")
    public LayuiDataTemplet<Memorandum> updateByMemorandumDeleteState(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (memorandum.getVersion() != null && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 删除
        int count = 0;
        count = memorandumService.updateByMemorandumDel(memorandum);
        // 返回数据
        if (count == 0) {
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("删除成功！");
        }
        return returnData;
    }
    /**
     * 根据idList删除信息(假删，更改状态)(0:删除、1：未删除)
     * @param memorandum  多条删除
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByMemorandumDellist")
    public LayuiDataTemplet<Memorandum> updateByMemorandumDellist(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (memorandum.getVersion() != null && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 删除
        int count = 0;
        count = memorandumService.updateByMemorandumDeleteState(memorandum.getIdlist());
        // 返回数据
        if (count == 0) {
            returnData.setCode(500);
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setCode(200);
            returnData.setMsg("删除成功！");
        }
        return returnData;
    }

    /**
     * 根据id 真删除
     * @param memorandum id 单条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByMemorandumid")
    public LayuiDataTemplet<Memorandum> deleteByMemorandumid(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (memorandum.getVersion() != null && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 删除
        int count = 0;
        memorandum.setmId("2");
        count = memorandumService.deleteByMemorandumid(memorandum);
        // 返回数据
        if (count == 0) {
            returnData.setCode(500);
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setCode(200);
            returnData.setMsg("删除成功！");
        }
        return returnData;
    }


    /**
     * 根据idList 真删除
     * @param memorandum  多条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByMemorandumidList")
    public LayuiDataTemplet<Memorandum> deleteByMemorandumidList(@RequestBody Memorandum memorandum) {
        LayuiDataTemplet<Memorandum> returnData = new LayuiDataTemplet<Memorandum>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (memorandum.getVersion() != null && !memorandum.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(memorandum.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 删除
        int count = 0;
        count = memorandumService.deleteByIdList(memorandum.getIdlist());
        // 返回数据
        if (count == 0) {
            returnData.setCode(500);
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setCode(200);
            returnData.setMsg("删除成功！");
        }
        return returnData;
    }
}
