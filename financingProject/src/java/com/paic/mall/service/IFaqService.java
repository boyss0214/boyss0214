package com.paic.mall.service;

import java.util.List;

import com.paic.mall.dto.FaqDTO;
import com.paic.mall.vo.QueryFaqVo;


public interface IFaqService {

	public List<FaqDTO> getFaqList(QueryFaqVo queryVo);

}
