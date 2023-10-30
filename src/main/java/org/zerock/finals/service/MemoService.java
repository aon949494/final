package org.zerock.finals.service;

import org.modelmapper.ModelMapper;
import org.zerock.finals.dao.MemoDAO;
import org.zerock.finals.domain.MemoVO;
import org.zerock.finals.domain.TodoVO;
import org.zerock.finals.dto.MemoDTO;
import org.zerock.finals.dto.TodoDTO;
import org.zerock.finals.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

public enum MemoService {
    INSTANCE;

    private MemoDAO dao;
    private ModelMapper modelMapper;
    MemoService(){
        dao=new MemoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    public void register(MemoDTO memoDTO)throws Exception{
        MemoVO memoVO = modelMapper.map(memoDTO,MemoVO.class);
        dao.insert(memoVO);
    }
    public List<MemoDTO> listAll(String id) throws Exception{
        List<MemoVO> voList = dao.selectAll(id);
        List<MemoDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo,MemoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
    public MemoDTO get(Long tno) throws Exception{
        MemoVO memoVO = dao.selectOne(tno);
        MemoDTO memoDTO = modelMapper.map(memoVO,MemoDTO.class);
        return memoDTO;
    }
    public void modify(MemoDTO memoDTO)throws Exception{
        MemoVO memoVO = modelMapper.map(memoDTO,MemoVO.class);
        dao.updateOne(memoVO);
    }
    public void remove(Long tno) throws Exception{
        dao.deleteOne(tno);
    }
    public void tnoReset() throws Exception{
        dao.alter();
        dao.set();
        dao.updat();
    }
}
