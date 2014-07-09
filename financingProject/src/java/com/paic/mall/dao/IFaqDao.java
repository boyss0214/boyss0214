package com.paic.mall.dao;

import java.util.List;

import com.paic.mall.dto.FaqDTO;
import com.paic.mall.vo.QueryFaqVo;

public interface IFaqDao extends
		IBaseDao<FaqDTO, java.lang.Integer> {

	public List<FaqDTO> getFaqList(QueryFaqVo queryVo);

}
