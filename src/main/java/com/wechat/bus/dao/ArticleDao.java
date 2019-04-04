package com.wechat.bus.dao;

import com.wechat.bus.entity.Article;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作日志
 */
@Repository
public class ArticleDao {


    private Logger logger = Logger.getLogger(ArticleDao.class);
    /**
     * 根据Article实体添加
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int insertByArticle(SqlSession session, Article article) {
        int num = 0;
        try {
            logger.info("ArticleDao");
            num = session.insert("com.wechat.bus.dao.mapper.Article.insertByArticle", article);
        } catch (Exception e) {
            logger.error("ArticleDao--insertByArticle--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Article实体更新
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByArticle(SqlSession session, Article article) {
        int num = 0;
        try {
            logger.info("ArticleDao");
            num = session.update("com.wechat.bus.dao.mapper.Article.updateByArticle", article);
        } catch (Exception e) {
            logger.error("ArticleDao--updateByArticle--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 查询单个实体
     * @param session
     * @param article  实体
     * @return
     */
    public Article selectByArticleone(SqlSession session, Article article) {
        Article articleone = new Article();
        try {
            logger.info("ArticleDao");
            articleone = session.selectOne("com.wechat.bus.dao.mapper.Article.selectByArticleone", article);
        } catch (Exception e) {
            logger.error("ArticleDao--selectByPrimaryKey--error:" + e.getMessage());
        }
        return articleone;
    }
    /**
     * 根据Article精准实体查询数量
     * 查询数量  int
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByArticle(SqlSession session, Article article) {
        int num = 0;
        try {
            logger.info("ArticleDao");
            num = session.selectOne("com.wechat.bus.dao.mapper.Article.selectCountByArticle", article);
        } catch (Exception e) {
            logger.error("ArticleDao--selectCountByArticle--error:" + e.getMessage());
        }
        return num;
    }

    /**
     * 根据Article精准实体查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public List<Article> selectByArticleList(SqlSession session, Article article) {
        List<Article> articleList = new ArrayList<Article>();
        try {
            logger.info("ArticleDao");
            articleList = session.selectList("com.wechat.bus.dao.mapper.Article.selectByArticleList", article);
        } catch (Exception e) {
            logger.error("ArticleDao--selectByArticle--error:" + e.getMessage());
        }
        return articleList;
    }
    /**
     * 根据Article实体模糊查询
     * 查询数量
     * @param article
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, Article article) {
        int num = 0;
        try {
            logger.info("ArticleDao");
            num = session.selectOne("com.wechat.bus.dao.mapper.Article.selectCountBySelectData", article);
        } catch (Exception e) {
            logger.error("ArticleDao--selectCountBySelectData--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Article实体模糊查询
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public List<Article> selectBySelectData(SqlSession session, Article article) {
        List<Article> article1List = new ArrayList<Article>();
        try {
            logger.info("ArticleDao");
            article1List = session.selectList("com.wechat.bus.dao.mapper.Article.selectBySelectData", article);
        } catch (Exception e) {
            logger.error("ArticleDao--selectBySelectData--error:" + e.getMessage());
        }
        return article1List;
    }

    /**
     * 根据实体id删除(假删、更改删除状态)
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int updateByArticleDeleteState(SqlSession session, Article article) {
        int num = 0;
        try {
            logger.info("ArticleDao");
            num = session.update("com.wechat.bus.dao.mapper.Article.updateByArticleDeleteState", article);
        } catch (Exception e) {
            logger.error("ArticleDao--updateByArticleDeleteState--error:" + e.getMessage());
        }
        return num;
    }
    /**
     * 根据Article实体单条删除
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByArticle(SqlSession session, Article article) {
        int num = 0;
        try {
            logger.info("ArticleDao");
            num = session.delete("com.wechat.bus.dao.mapper.Article.deleteByArticle", article);
        } catch (Exception e) {
            logger.error("ArticleDao--deleteByArticle--error:" + e.getMessage());
        }
        return num;
    }

    /**
     * 根据Article实体多条条删除
     * @param id
     * @return
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByidlist(SqlSession session, String id) {
        int num = 0;
        try {
            logger.info("ArticleDao");
            num = session.delete("com.wechat.bus.dao.mapper.Article.deleteByidlist", id);
        } catch (Exception e) {
            logger.error("ArticleDao--deleteByPrimaryKey--error:" + e.getMessage());
        }
        return num;
    }
}