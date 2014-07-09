package com.paic.mall.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.paic.mall.dao.IFaqDao;
import com.paic.mall.dto.FaqDTO;
import com.paic.mall.vo.QueryFaqVo;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository("faqDao")
public class FaqDaoImpl extends BaseDaoImpl<FaqDTO, java.lang.Integer>
		implements IFaqDao {

	public List<FaqDTO> getFaqList(QueryFaqVo queryVo) {
		Map<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("faqTypeList", queryVo.getFaqTypeList());
		List<FaqDTO> result = this.getSqlMapClientTemplate().queryForList("faq.getFaqList",paramMap);
		return result;
	}

	@Override
	public Class<FaqDTO> getEntityClass() {
		return FaqDTO.class;
	}


}
