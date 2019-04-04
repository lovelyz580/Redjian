package com.wechat.bus.restful;

import com.wechat.bus.entity.Record;
import com.wechat.bus.service.RecordService;
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
 * on 2019-04-04 13:36
 */
@Controller
@RequestMapping("/record")
public class H_RecordRestful {
    @Autowired
    private RecordService recordService;
    /**
     * 根据Record实体添加
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByRecord")
    public LayuiDataTemplet<Record> insertByRecord(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不能为空，验证版本号
        try {
            if (null != record.getVersion() && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        Record recordSelectData = new Record();
        recordSelectData.setRecordName("333");//登录名
        Record recordone = recordService.selectByRecordone(recordSelectData); // 查询数据
        if (recordone.getRecordId() !=null) {
            returnData.setMsg("该用户已注册、请登录！");
            return returnData;
        }
        // 添加数据
        record.setRecordId(UUID.randomUUID().toString());
        record.setRecordImg("images");//未知 男女
        record.setRecordUid("1");
        // 添加
        int count = 0;
        count = recordService.insertByRecord(record);
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
     * 根据Record实体更新
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRecord")
    public LayuiDataTemplet<Record> updateByRecord(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (record.getVersion() != null && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        record.setRecordId("444");
        if (record.getRecordId() == null || record.getRecordId() == "") {
            if (record.getRecordId() == null || record.getRecordId().isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }
        // 更新数据
        //MD5加密MD5Util.encrypt(record1.getrecordpassword();
        // 更新时间
        // 更新
        record.setRecordName("我正在更新");
        int count = 0;
        count = recordService.updateByRecord(record);
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
     * 根据Record实体查询 单条数据
     * @param record  单条数据
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByRecordid")
    public LayuiDataTemplet<Record> selectByRecordid(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (record.getVersion() != null && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        record.setRecordId("233");
        Record recordone = recordService.selectByRecordone(record); // 查询数据
        if (recordone!=null){
            returnData.setCount(1);
            returnData.setOnedata(recordone);
        }else {
            returnData.setCount(0);
            returnData.setMsg("暂无数据");
        }
        returnData.setOnedata(recordone);
        return returnData;
    }
    /**
     * 根据Record实体联表查询 多条数据
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByRecordlist")
    public LayuiDataTemplet<Record> selectByRecordlist(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (record.getVersion() != null && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        if (record.getPagenumber() != null) {
            // 计算偏移量
            if (record.getPagenumber() != -1) {
                if (record.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }
                // 获取传递过来的数据
                int pageNumber = record.getPagenumber();
                int pageSize = record.getPagesize();
                record.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                record.setPagesize(pageSize); // 每页的数据量
            }
            // 查询数量
            int count = 0;
            count = recordService.selectCountByRecord(record);
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Record> recordList = recordService.selectByRecordList(record); // 查询数据
                returnData.setData(recordList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }
        return returnData;
    }
    /**
     * 根据Record实体联表模糊查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<Record> selectBySelectData(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (record.getVersion() != null && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        if (record.getPagenumber() != null) {
            // 计算偏移量
            if (record.getPagenumber() != -1) {
                if (record.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = record.getPagenumber();
                int pageSize = record.getPagesize();
                record.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                record.setPagesize(pageSize); // 每页的数据量
            }
            // 查询数量
            int count = 0;
            count = recordService.selectCountBySelectData(record); // 查询数量
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Record> record1List = recordService.selectBySelectData(record); // 查询数据
                returnData.setData(record1List);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }
        return returnData;
    }
    /**
     * 根据Record实体删除信息(假删，更改状态)(0:删除、1：未删除)
     * @param record 单条删除
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRecordDel")
    public LayuiDataTemplet<Record> updateByRecordDeleteState(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (record.getVersion() != null && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        record.setRecordState(0); //假删除
        count = recordService.updateByRecordDel(record);
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
     * 根据idList删除信息(假删，更改状态)(0:删除、1：未删除)
     * @param record  多条删除
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRecordDellist")
    public LayuiDataTemplet<Record> updateByRecordDellist(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (record.getVersion() != null && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        count = recordService.updateByRecordDeleteState(record.getIdlist());
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
     * @param record id 单条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByRecordid")
    public LayuiDataTemplet<Record> deleteByRecordid(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (record.getVersion() != null && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        record.setRecordId("23");
        count = recordService.deleteByRecordid(record);
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
     * @param record  多条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByRecordidList")
    public LayuiDataTemplet<Record> deleteByRecordidList(@RequestBody Record record) {
        LayuiDataTemplet<Record> returnData = new LayuiDataTemplet<Record>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (record.getVersion() != null && !record.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(record.getVersion(), Config.VERSION);
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
        count = recordService.deleteByIdList(record.getIdlist());
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
