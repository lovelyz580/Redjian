package com.wechat.bus.restful;

import com.wechat.bus.entity.Article;
import com.wechat.bus.service.ArticleService;
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
 * on 2019-04-04 13:50
 */
@Controller
@RequestMapping("/article")
public class H_ArticleRestful {
    @Autowired
    private ArticleService articleService;
    /**
     * 根据Article实体添加
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByArticle")
    public LayuiDataTemplet<Article> insertByArticle(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不能为空，验证版本号
        try {
            if (null != article.getVersion() && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        Article articleSelectData = new Article();
     articleSelectData.setArticleName("学习");//登录名
        Article articleone = articleService.selectByArticleone(articleSelectData); // 查询数据
        if (articleone !=null) {
            returnData.setMsg("该用户已注册、请登录！");
            return returnData;
        }
        // 添加数据
        article.setArticleName("images");//未知 男女
        article.setArticleId(UUID.randomUUID().toString());
        article.setArticleUid("1");
        // 添加
        int count = 0;
        count = articleService.insertByArticle(article);
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
     * 根据Article实体更新
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByArticle")
    public LayuiDataTemplet<Article> updateByArticle(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (article.getVersion() != null && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        article.setArticleId("56");
        if (article.getArticleId() == null || article.getArticleId() == "") {
            if (article.getArticleId() == null || article.getArticleId().isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }
        // 更新数据
        //MD5加密MD5Util.encrypt(article.getarticlepassword();
        // 更新时间
        article.setArticleName("学习");
        // 更新
        int count = 0;
        count = articleService.updateByArticle(article);
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
     * 根据Article实体查询 单条数据
     * @param article  单条数据
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByArticleid")
    public LayuiDataTemplet<Article> selectByArticleid(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (article.getVersion() != null && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        article.setArticleId("12");
        Article articleone = articleService.selectByArticleone(article); // 查询数据
        if (articleone!=null){
            returnData.setCount(1);
            returnData.setOnedata(articleone);
        }else {
            returnData.setCount(0);
            returnData.setMsg("暂无数据");
        }
        returnData.setOnedata(articleone);
        return returnData;
    }
    /**
     * 根据Article实体联表查询 多条数据
     * 可以进行分页查询
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     * pageSize 每页的数据量
     * @param article
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByArticlelist")
    public LayuiDataTemplet<Article> selectByArticlelist(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (article.getVersion() != null && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        if (article.getPagenumber() != null) {
            // 计算偏移量
            if (article.getPagenumber() != -1) {
                if (article.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }
                // 获取传递过来的数据
                int pageNumber = article.getPagenumber();
                int pageSize = article.getPagesize();
                article.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                article.setPagesize(pageSize); // 每页的数据量
            }
            // 查询数量
            int count = 0;
            count = articleService.selectCountByArticle(article);
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Article> articleList = articleService.selectByArticleList(article); // 查询数据
                returnData.setData(articleList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }
        return returnData;
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
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<Article> selectBySelectData(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (article.getVersion() != null && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        if (article.getPagenumber() != null) {
            // 计算偏移量
            if (article.getPagenumber() != -1) {
                if (article.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = article.getPagenumber();
                int pageSize = article.getPagesize();
                article.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                article.setPagesize(pageSize); // 每页的数据量
            }
            // 查询数量
            int count = 0;
            count = articleService.selectCountBySelectData(article); // 查询数量
            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<Article> article1List = articleService.selectBySelectData(article); // 查询数据
                returnData.setData(article1List);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }
        return returnData;
    }
    /**
     * 根据Article实体删除信息(假删，更改状态)(0:删除、1：未删除)
     * @param article 单条删除
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByArticleDel")
    public LayuiDataTemplet<Article> updateByArticleDeleteState(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (article.getVersion() != null && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        article.setArticleId("56");
        count = articleService.updateByArticleDel(article);
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
     * @param article  多条删除
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByArticleDellist")
    public LayuiDataTemplet<Article> updateByArticleDellist(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (article.getVersion() != null && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        count = articleService.updateByArticleDeleteState(article.getIdlist());
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
     * @param article id 单条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByArticleid")
    public LayuiDataTemplet<Article> deleteByArticleid(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (article.getVersion() != null && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        article.setArticleId("56");
        count = articleService.deleteByArticleid(article);
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
     * @param article  多条
     * @return
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByArticleidList")
    public LayuiDataTemplet<Article> deleteByArticleidList(@RequestBody Article article) {
        LayuiDataTemplet<Article> returnData = new LayuiDataTemplet<Article>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (article.getVersion() != null && !article.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(article.getVersion(), Config.VERSION);
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
        count = articleService.deleteByIdList(article.getIdlist());
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
