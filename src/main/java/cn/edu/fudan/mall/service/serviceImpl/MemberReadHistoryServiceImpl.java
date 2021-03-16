package cn.edu.fudan.mall.service.serviceImpl;

import cn.edu.fudan.mall.nosql.mongodb.pojo.MemberReadHistory;
import cn.edu.fudan.mall.nosql.mongodb.repository.MemberReadHistoryRepository;
import cn.edu.fudan.mall.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {

    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(MemberReadHistory memberReadHistory) {
        memberReadHistoryRepository.delete(memberReadHistory);
        return 1;
    }

    @Override
    public List<MemberReadHistory> getReadHistory(Long id) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(id);
    }
}
