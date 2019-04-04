package com.wechat.bus.dao;

import com.wechat.bus.entity.Record;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作学习记录
 */
@Repository
public class RecordDao {
    private Logger logger = Logger.getLogger(RecordDao.class);
    /**
     * 根据Record实体添加
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int insertByRecord(SqlSession session, Record record) {
        int num = 0;
        try {
            logger.info("RecordDao");
            num = session.insert("com.wechat.bus.dao.mapper.Record.insertByRecord", record);
        } catch (Exception e) {
            logger.error("RecordDao--insertByRecord--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Record实体更新
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRecord(SqlSession session, Record record) {
        int num = 0;
        try {
            logger.info("RecordDao");
            num = session.update("com.wechat.bus.dao.mapper.Record.updateByRecord", record);
        } catch (Exception e) {
            logger.error("RecordDao--updateByRecord--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 查询单个实体
     * @param session
     * @param record  实体
     * @return
     */
    public Record selectByRecordone(SqlSession session, Record record) {
        Record recordone = new Record();
        try {
            logger.info("RecordDao");
            recordone = session.selectOne("com.wechat.bus.dao.mapper.Record.selectByRecordone", record);
        } catch (Exception e) {
            logger.error("RecordDao--selectByPrimaryKey--error:" + e.getMessage());
        }
        return recordone;
    }
    /**
     * 根据Record精准实体查询数量
     * 查询数量  int
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByRecord(SqlSession session, Record record) {
        int num = 0;
        try {
            logger.info("RecordDao");
            num = session.selectOne("com.wechat.bus.dao.mapper.Record.selectCountByRecord", record);
        } catch (Exception e) {
            logger.error("RecordDao--selectCountByRecord--error:" + e.getMessage());
        }
        return num;
    }

    /**
     * 根据Record精准实体查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public List<Record> selectByRecordList(SqlSession session, Record record) {
        List<Record> recordList = new ArrayList<Record>();
        try {
            logger.info("RecordDao");
            recordList = session.selectList("com.wechat.bus.dao.mapper.Record.selectByRecordList", record);
        } catch (Exception e) {
            logger.error("RecordDao--selectByRecord--error:" + e.getMessage());
        }
        return recordList;
    }
    /**
     * 根据Record实体模糊查询
     * 查询数量
     * @param record
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, Record record) {
        int num = 0;
        try {
            logger.info("RecordDao");
            num = session.selectOne("com.wechat.bus.dao.mapper.Record.selectCountBySelectData", record);
        } catch (Exception e) {
            logger.error("RecordDao--selectCountBySelectData--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Record实体模糊查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public List<Record> selectBySelectData(SqlSession session, Record record) {
        List<Record> record1List = new ArrayList<Record>();
        try {
            logger.info("RecordDao");
            record1List = session.selectList("com.wechat.bus.dao.mapper.Record.selectBySelectData", record);
        } catch (Exception e) {
            logger.error("RecordDao--selectBySelectData--error:" + e.getMessage());
        }
        return record1List;
    }

    /**
     * 根据实体id删除(假删、更改删除状态)
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRecordDeleteState(SqlSession session, Record record) {
        int num = 0;
        try {
            logger.info("RecordDao");
            num = session.update("com.wechat.bus.dao.mapper.Record.updateByRecordDeleteState", record);
        } catch (Exception e) {
            logger.error("RecordDao--updateByRecordDeleteState--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Record实体单条删除
     * @param record
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByRecord(SqlSession session, Record record) {
        int num = 0;
        try {
            logger.info("RecordDao");
            num = session.delete("com.wechat.bus.dao.mapper.Record.deleteByRecord", record);
        } catch (Exception e) {
            logger.error("RecordDao--deleteByRecord--error:" + e.getMessage());
        }
        return num;
    }

    /**
     * 根据Record实体多条条删除
     * @param id
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByidlist(SqlSession session, String id) {
        int num = 0;
        try {
            logger.info("RecordDao");
            num = session.delete("com.wechat.bus.dao.mapper.Record.deleteByidlist", id);
        } catch (Exception e) {
            logger.error("RecordDao--deleteByPrimaryKey--error:" + e.getMessage());
        }
        return num;
    }
}