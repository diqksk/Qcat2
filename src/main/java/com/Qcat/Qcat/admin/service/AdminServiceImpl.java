package com.Qcat.Qcat.admin.service;

import com.Qcat.Qcat.admin.repository.AdminMapper;
import com.Qcat.Qcat.market.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<HashMap<String, Object>> getResumeList(Criteria cri) {
        return adminMapper.getResumeList(cri);
    }

    @Override
    public int countTotalResume() {
        return adminMapper.countTotalResume();
    }

    @Override
    public int createNewStore(HashMap<String, String> formInfo) {
        return adminMapper.createNewStore(formInfo);
    }

    @Override
    public int updateResumeRole(HashMap<String, String> formInfo) {
        return adminMapper.updateResumeRole(formInfo);
    }

    @Override
    public int refuseResume(HashMap<String, String> formInfo) {
        return adminMapper.refuseResume(formInfo);
    }
}
