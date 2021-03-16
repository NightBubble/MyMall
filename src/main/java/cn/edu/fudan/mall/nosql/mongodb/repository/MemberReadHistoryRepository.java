package cn.edu.fudan.mall.nosql.mongodb.repository;

import cn.edu.fudan.mall.nosql.mongodb.pojo.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
    /**
     * 根据用户ID按时间倒序排序
     * @param memberId
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
