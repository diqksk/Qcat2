package com.Qcat.Qcat.admin.service;

import com.Qcat.Qcat.market.domain.Criteria;

import java.util.HashMap;
import java.util.List;

public interface AdminService {
    List<HashMap<String, Object>> getResumeList(Criteria cri);
    int countTotalResume();
    int createNewStore(HashMap<String, String> formInfo);
    int updateResumeRole(HashMap<String, String> formInfo);
    int refuseResume(HashMap<String, String> formInfo);
}
