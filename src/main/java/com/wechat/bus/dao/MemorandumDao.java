package com.wechat.bus.dao;

import com.wechat.bus.entity.Memorandum;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录操作
 */
@Repository
public class MemorandumDao {

    private Logger logger = Logger.getLogger(MemorandumDao.class);
    /**
     * 根据Memorandum实体添加
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int insertByMemorandum(SqlSession session, Memorandum memorandum) {
        int num = 0;
        try {
            logger.info("MemorandumDao");
            num = session.insert("com.wechat.bus.dao.mapper.Memorandum.insertByMemorandum", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--insertByMemorandum--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Memorandum实体更新
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByMemorandum(SqlSession session, Memorandum memorandum) {
        int num = 0;
        try {
            logger.info("MemorandumDao");
            num = session.update("com.wechat.bus.dao.mapper.Memorandum.updateByMemorandum", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--updateByMemorandum--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 查询单个实体
     * @param session
     * @param memorandum  实体
     * @return
     */
    public Memorandum selectByMemorandumone(SqlSession session, Memorandum memorandum) {
        Memorandum memorandumone = new Memorandum();
        try {
            logger.info("MemorandumDao");
            memorandumone = session.selectOne("com.wechat.bus.dao.mapper.Memorandum.selectByMemorandumone", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--selectByPrimaryKey--error:" + e.getMessage());
        }
        return memorandumone;
    }
    /**
     * 根据Memorandum精准实体查询数量
     * 查询数量  int
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByMemorandum(SqlSession session, Memorandum memorandum) {
        int num = 0;
        try {
            logger.info("MemorandumDao");
            num = session.selectOne("com.wechat.bus.dao.mapper.Memorandum.selectCountByMemorandum", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--selectCountByMemorandum--error:" + e.getMessage());
        }
        return num;
    }

    /**
     * 根据Memorandum精准实体查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public List<Memorandum> selectByMemorandumList(SqlSession session, Memorandum memorandum) {
        List<Memorandum> memorandumList = new ArrayList<Memorandum>();
        try {
            logger.info("MemorandumDao");
            memorandumList = session.selectList("com.wechat.bus.dao.mapper.Memorandum.selectByMemorandumList", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--selectByMemorandum--error:" + e.getMessage());
        }
        return memorandumList;
    }
    /**
     * 根据Memorandum实体模糊查询
     * 查询数量
     * @param memorandum
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, Memorandum memorandum) {
        int num = 0;
        try {
            logger.info("MemorandumDao");
            num = session.selectOne("com.wechat.bus.dao.mapper.Memorandum.selectCountBySelectData", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--selectCountBySelectData--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Memorandum实体模糊查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public List<Memorandum> selectBySelectData(SqlSession session, Memorandum memorandum) {
        List<Memorandum> memorandum1List = new ArrayList<Memorandum>();
        try {
            logger.info("MemorandumDao");
            memorandum1List = session.selectList("com.wechat.bus.dao.mapper.Memorandum.selectBySelectData", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--selectBySelectData--error:" + e.getMessage());
        }
        return memorandum1List;
    }

    /**
     * 根据实体id删除(假删、更改删除状态)
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByMemorandumDeleteState(SqlSession session, Memorandum memorandum) {
        int num = 0;
        try {
            logger.info("MemorandumDao");
            num = session.update("com.wechat.bus.dao.mapper.Memorandum.updateByMemorandumDeleteState", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--updateByMemorandumDeleteState--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Memorandum实体单条删除
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByMemorandum(SqlSession session, Memorandum memorandum) {
        int num = 0;
        try {
            logger.info("MemorandumDao");
            num = session.delete("com.wechat.bus.dao.mapper.Memorandum.deleteByMemorandum", memorandum);
        } catch (Exception e) {
            logger.error("MemorandumDao--deleteByMemorandum--error:" + e.getMessage());
        }
        return num;
    }

    /**
     * 根据Memorandum实体多条条删除
     * @param id
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByidlist(SqlSession session, String id) {
        int num = 0;
        try {
            logger.info("MemorandumDao");
            num = session.delete("com.wechat.bus.dao.mapper.Memorandum.deleteByidlist", id);
        } catch (Exception e) {
            logger.error("MemorandumDao--deleteByPrimaryKey--error:" + e.getMessage());
        }
        return num;
    }
}