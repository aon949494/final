package org.zerock.finals.service;

import org.modelmapper.ModelMapper;
import org.zerock.finals.dao.HealthDAO;
import org.zerock.finals.domain.HealthVO;
import org.zerock.finals.dto.HealthDTO;
import org.zerock.finals.util.MapperUtil;

public enum HealthService {
    INSTANCE;
    private HealthDAO dao;
    private ModelMapper modelMapper;

    HealthService(){
        dao=new HealthDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    public void register(HealthDTO healthDTO)throws Exception{
        HealthVO healthVO = modelMapper.map(healthDTO,HealthVO.class);
        dao.insert(healthVO);
    }
}
