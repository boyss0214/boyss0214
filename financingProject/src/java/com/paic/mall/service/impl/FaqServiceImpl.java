package com.paic.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paic.mall.dao.IFaqDao;
import com.paic.mall.dto.FaqDTO;
import com.paic.mall.service.IFaqService;
import com.paic.mall.vo.QueryFaqVo;

@Service("faqService")
public class FaqServiceImpl implements IFaqService {
	@Autowired
	private IFaqDao faqDao;

	public List<FaqDTO> getFaqList(QueryFaqVo queryVo) {
		return this.faqDao.getFaqList(queryVo);
	}
}
