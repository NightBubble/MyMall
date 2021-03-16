package cn.edu.fudan.mall.service;

import cn.edu.fudan.mall.nosql.mongodb.pojo.MemberReadHistory;

import java.util.List;

public interface MemberReadHistoryService {
    /**
     * 生成历史记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 删除历史记录
     * @param memberReadHistory
     * @return
     */
    int delete(MemberReadHistory memberReadHistory);

    /**
     * 读取历史记录
     * @param id
     * @return
     */
    List<MemberReadHistory> getReadHistory(Long id);
}
