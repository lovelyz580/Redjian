package com.wechat.bus.service;

import com.wechat.bus.dao.MemorandumDao;
import com.wechat.bus.entity.Memorandum;
import com.wechat.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-04 13:22
 */
@Service
public class MemorandumService {
    @Autowired
    private MemorandumDao memorandumDao;
    private Logger logger = Logger.getLogger(MemorandumService.class);
    /**
     * 根据Memorandum实体添加
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int insertByMemorandum(Memorandum memorandum) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = memorandumDao.insertByMemorandum(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--insertByMemorandum--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Memorandum实体更新
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByMemorandum(Memorandum memorandum) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = memorandumDao.updateByMemorandum(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--updateByMemorandum--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Memorandum实体联表查询
     * 查询数量
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByMemorandum(Memorandum memorandum) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = memorandumDao.selectCountByMemorandum(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--selectCountByMemorandum--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Memorandum实体查询
     * 查询单个实体
     * @param memorandum
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public Memorandum selectByMemorandumone(Memorandum memorandum) {
        Memorandum memorandumone = new Memorandum();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            memorandumone = memorandumDao.selectByMemorandumone(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--selectByMemorandum--error:" + e.getMessage());
        }
        return memorandumone;
    }
    /**
     * 根据Memorandum实体联表查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param memorandum
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public List<Memorandum> selectByMemorandumList(Memorandum memorandum) {
        List<Memorandum> memorandum1List = new ArrayList<Memorandum>();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            memorandum1List = memorandumDao.selectByMemorandumList(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--selectByMemorandum--error:" + e.getMessage());
        }
        return memorandum1List;
    }
    /**
     * 根据Memorandum实体联表模糊查询
     * 查询数量
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(Memorandum memorandum) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = memorandumDao.selectCountBySelectData(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--selectCountBySelectData--error:" + e.getMessage());
        }
        return num;
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
    public List<Memorandum> selectBySelectData(Memorandum memorandum) {
        List<Memorandum> memorandum1List = new ArrayList<Memorandum>();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            memorandum1List = memorandumDao.selectBySelectData(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--selectBySelectData--error:" + e.getMessage());
        }
        return memorandum1List;
    }

    /**
     * 根据Memorandum实体删除信息(假删、更改状态)
     * @param memorandum   单条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByMemorandumDel(Memorandum memorandum) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            // 执行假删除
            deleteNum = deleteNum + memorandumDao.updateByMemorandumDeleteState(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--updateByMemorandumDeleteState--error:" + e.getMessage());
        }
        return deleteNum;
    }
    /**
     * 根据idList删除信息(假删、更改状态)
     * @param list   多条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByMemorandumDeleteState(List<String> list) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            for (int i = 0; i < list.size(); i++) {
                Memorandum memorandum = new Memorandum();
//                执行假删除
                deleteNum = deleteNum + memorandumDao.updateByMemorandumDeleteState(session, memorandum);
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--updateByMemorandumDeleteState--error:" + e.getMessage());
        }
        return deleteNum;
    }

    /**
     * 根据Memorandum 实体真删除信息
     * @param memorandum
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByMemorandumid(Memorandum memorandum) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            deleteNum = deleteNum + memorandumDao.deleteByMemorandum(session, memorandum);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--deleteByIdList--error:" + e.getMessage());
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
                deleteNum = deleteNum + memorandumDao.deleteByidlist(session, list.get(i));
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("MemorandumService--deleteByIdList--error:" + e.getMessage());
        }
        return deleteNum;
    }

}

