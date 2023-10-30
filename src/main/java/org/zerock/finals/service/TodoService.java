package org.zerock.finals.service;

import org.modelmapper.ModelMapper;
import org.zerock.finals.dao.TodoDAO;
import org.zerock.finals.domain.TodoVO;
import org.zerock.finals.dto.TodoDTO;
import org.zerock.finals.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService(){
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception{
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        System.out.println("todoVO: "+ todoVO);
        dao.insert(todoVO);
    }

    public List<TodoDTO> listAll(String id) throws Exception{
        List<TodoVO> voList = dao.selectAll(id);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    public TodoDTO get(Long tno) throws Exception{
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    public void modify(TodoDTO todoDTO) throws Exception{
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        dao.updateOne(todoVO);
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
