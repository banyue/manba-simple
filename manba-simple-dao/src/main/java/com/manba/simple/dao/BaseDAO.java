package com.manba.simple.dao;

import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.page.PageList;
import com.manba.simple.domain.page.SearchCriteria;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by lijin on 2017/9/27.
 */
public class BaseDAO<T> extends SqlSessionDaoSupport {

    /**
     * 插入新记录
     * @param statement     sql实例
     * @param entity        插入实体
     * @return  true-成功，false-失败
     */
    public boolean insert(String statement, T entity) {
        boolean flag = (getSqlSession().insert(statement, entity) > 0);
        return flag;
    }

    /**
     * 修改记录
     * @param statement     sql实例
     * @param entity        插入实体
     * @return  修改的记录数
     */
    public int update(String statement, T entity) {
        return getSqlSession().update(statement, entity);
    }

    /**
     * 删除记录
     * @param statement     sql实例
     * @param entity        删除的实体
     * @return  删除的记录数
     */
    public int delete(String statement, T entity) {
        return getSqlSession().delete(statement, entity);
    }

    /**
     * 获取满足条件的记录数
     * @param statement  sql实例
     * @param criteria   查询条件
     * @return   满足条件的记录数
     */
    public int getCount(String statement, Object criteria) {
        Object result = getSqlSession().selectOne(statement, criteria);
        Integer count;
        try {
            count = (null == result) ? 0 : (Integer) result;
        } catch (ClassCastException e) {
            logger.error("sql语句：" + statement + "查询结果非数字类型，无法用于查询数量");
            throw e;
        }
        return count;
    }

    /**
     * 获取实体对象信息
     * @param statement  sql实例
     * @param criteria  查询条件
     * @return
     */
    public T getObject(String statement, Object criteria) {
        T result = (T) getSqlSession().selectOne(statement, criteria);
        return result;
    }

    /**
     * 查询实体信息
     * @param statement
     * @param criteria
     * @return
     */
    public <E> List<E> queryForList(String statement, Object criteria) {
        List<E> result = getSqlSession().selectList(statement, criteria);
        return result;
    }

    /**
     * 查询,支持分页，若查询条件设置为不分页则查询所有
     *
     * @param listStatement     列表记录查询实例
     * @param countStatement    记录数查询实例
     * @param criteria          查询条件
     * @param <E>   返回的行记录类型
     * @return
     */
    public <E> PageList<E> search(String listStatement, String countStatement, SearchCriteria criteria) {
        Assert.notNull(criteria, "查询条件不能为空.");
        PageList<E> pageList = new PageList<E>();
        List<E> resultList = null;
        if (criteria.isDoPage()) {
            if (criteria.isAutoCount()) {
                Integer count = (Integer) this.getCount(countStatement, criteria);
                pageList.setTotalCount(count);
                if (count <= 0) {
                    return pageList;
                }
            }
            criteria.addExtField("start", (criteria.getPageNo() - 1) * criteria.getPageSize());
            resultList = this.queryForList(listStatement, criteria);
        } else {
            resultList = this.queryForList(listStatement, criteria);
        }
        pageList.addAll(resultList);
        return pageList;
    }

    /**
     * 分页查询，若查询条件设置为不分页则查询所有
     *
     * @param listStatement     列表记录查询实例
     * @param countStatement    记录数查询实例
     * @param criteria          查询条件
     * @param <E>   返回的行记录类型
     * @return
     */
    public <E> PageBean<E> pageSearch(String listStatement, String countStatement, SearchCriteria criteria) {
        Assert.notNull(criteria, "查询条件不能为空.");
        PageBean<E> pageBean = new PageBean<E>();
        List<E> resultList = null;
        if (criteria.isDoPage()) {
            if (criteria.isAutoCount()) {
                Integer count = (Integer) this.getCount(countStatement, criteria);
                pageBean.setTotalCount(count);
                if (count <= 0) {
                    return pageBean;
                }
            }
            criteria.addExtField("start", (criteria.getPageNo() - 1) * criteria.getPageSize());
            resultList = this.queryForList(listStatement, criteria);
        } else {
            resultList = this.queryForList(listStatement, criteria);
        }
        pageBean.setResultList(resultList);
        return pageBean;
    }
}
