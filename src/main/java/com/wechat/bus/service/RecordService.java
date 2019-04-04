package com.wechat.bus.service;

import com.wechat.bus.dao.RecordDao;
import com.wechat.bus.entity.Record;
import com.wechat.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-04 13:15
 */
@Service
public class RecordService {
    @Autowired
    private RecordDao recordDao;
    private Logger logger = Logger.getLogger(RecordService.class);
    /**
     * 根据Record实体添加
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int insertByRecord(Record record) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = recordDao.insertByRecord(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--insertByRecord--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Record实体更新
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRecord(Record record) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = recordDao.updateByRecord(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--updateByRecord--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Record实体联表查询
     * 查询数量
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByRecord(Record record) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = recordDao.selectCountByRecord(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--selectCountByRecord--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Record实体查询
     * 查询单个实体
     * @param record
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public Record selectByRecordone(Record record) {
        Record recordone = new Record();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            recordone = recordDao.selectByRecordone(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--selectByRecord--error:" + e.getMessage());
        }
        return recordone;
    }
    /**
     * 根据Record实体联表查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param record
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public List<Record> selectByRecordList(Record record) {
        List<Record> record1List = new ArrayList<Record>();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            record1List = recordDao.selectByRecordList(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--selectByRecord--error:" + e.getMessage());
        }
        return record1List;
    }
    /**
     * 根据Record实体联表模糊查询
     * 查询数量
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(Record record) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = recordDao.selectCountBySelectData(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--selectCountBySelectData--error:" + e.getMessage());
        }
        return num;
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
    public List<Record> selectBySelectData(Record record) {
        List<Record> record1List = new ArrayList<Record>();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            record1List = recordDao.selectBySelectData(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--selectBySelectData--error:" + e.getMessage());
        }
        return record1List;
    }

    /**
     * 根据Record实体删除信息(假删、更改状态)
     * @param record   单条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRecordDel(Record record) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            // 执行假删除
            deleteNum = deleteNum + recordDao.updateByRecordDeleteState(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--updateByRecordDeleteState--error:" + e.getMessage());
        }
        return deleteNum;
    }
    /**
     * 根据idList删除信息(假删、更改状态)
     * @param list   多条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRecordDeleteState(List<String> list) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            for (int i = 0; i < list.size(); i++) {
                Record record = new Record();
//                执行假删除
                deleteNum = deleteNum + recordDao.updateByRecordDeleteState(session, record);
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--updateByRecordDeleteState--error:" + e.getMessage());
        }
        return deleteNum;
    }

    /**
     * 根据Record 实体真删除信息
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByRecordid(Record record) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            deleteNum = deleteNum + recordDao.deleteByRecord(session, record);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--deleteByIdList--error:" + e.getMessage());
        }
        return deleteNum;
    }

    /**
     * 根据idList真删除信息
     * @param list
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByIdList(List<String> list) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            for (int i = 0; i < list.size(); i++) {
                deleteNum = deleteNum + recordDao.deleteByidlist(session, list.get(i));
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RecordService--deleteByIdList--error:" + e.getMessage());
        }
        return deleteNum;
    }

}
