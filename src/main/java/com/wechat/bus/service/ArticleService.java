package com.wechat.bus.service;

import com.wechat.bus.dao.ArticleDao;
import com.wechat.bus.entity.Article;
import com.wechat.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-04 13:29
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    private Logger logger = Logger.getLogger(ArticleService.class);
    /**
     * 根据Article实体添加
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int insertByArticle(Article article) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = articleDao.insertByArticle(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--insertByArticle--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Article实体更新
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByArticle(Article article) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = articleDao.updateByArticle(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--updateByArticle--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Article实体联表查询
     * 查询数量
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByArticle(Article article) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = articleDao.selectCountByArticle(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--selectCountByArticle--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Article实体查询
     * 查询单个实体
     * @param article
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public Article selectByArticleone(Article article) {
        Article articleone = new Article();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            articleone = articleDao.selectByArticleone(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--selectByArticle--error:" + e.getMessage());
        }
        return articleone;
    }
    /**
     * 根据Article实体联表查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param article
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public List<Article> selectByArticleList(Article article) {
        List<Article> article1List = new ArrayList<Article>();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            article1List = articleDao.selectByArticleList(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--selectByArticle--error:" + e.getMessage());
        }
        return article1List;
    }
    /**
     * 根据Article实体联表模糊查询
     * 查询数量
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(Article article) {
        int num = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            num = articleDao.selectCountBySelectData(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--selectCountBySelectData--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Article实体联表模糊查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public List<Article> selectBySelectData(Article article) {
        List<Article> article1List = new ArrayList<Article>();
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            article1List = articleDao.selectBySelectData(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--selectBySelectData--error:" + e.getMessage());
        }
        return article1List;
    }

    /**
     * 根据Article实体删除信息(假删、更改状态)
     * @param article   单条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByArticleDel(Article article) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            // 执行假删除
            deleteNum = deleteNum + articleDao.updateByArticleDeleteState(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--updateByArticleDeleteState--error:" + e.getMessage());
        }
        return deleteNum;
    }
    /**
     * 根据idList删除信息(假删、更改状态)
     * @param list   多条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByArticleDeleteState(List<String> list) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            for (int i = 0; i < list.size(); i++) {
                Article article = new Article();
//                执行假删除
                deleteNum = deleteNum + articleDao.updateByArticleDeleteState(session, article);
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--updateByArticleDeleteState--error:" + e.getMessage());
        }
        return deleteNum;
    }

    /**
     * 根据Article 实体真删除信息
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByArticleid(Article article) {
        int deleteNum = 0;
        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
            deleteNum = deleteNum + articleDao.deleteByArticle(session, article);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--deleteByIdList--error:" + e.getMessage());
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
                deleteNum = deleteNum + articleDao.deleteByidlist(session, list.get(i));
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("ArticleService--deleteByIdList--error:" + e.getMessage());
        }
        return deleteNum;
    }

}
