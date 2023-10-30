package org.zerock.finals.service;

import org.modelmapper.ModelMapper;
import org.zerock.finals.dao.MemberDAO;
import org.zerock.finals.dao.MemoDAO;
import org.zerock.finals.dao.TodoDAO;
import org.zerock.finals.domain.MemberVO;
import org.zerock.finals.dto.MemberDTO;
import org.zerock.finals.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

public enum MemberService {
    INSTANCE;
    private MemberDAO dao;
    private TodoDAO todoDAO;
    private MemoDAO memoDAO;
    private ModelMapper modelMapper;

    MemberService(){
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    public List<MemberDTO> listAll() throws Exception{
        List<MemberVO> voList = dao.selectAll();
        List<MemberDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo,MemberDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
    public MemberDTO login(String mid, String mpw) throws Exception{
        MemberVO memberVO = dao.getWithPassword(mid,mpw);
        MemberDTO memberDTO = modelMapper.map(memberVO,MemberDTO.class);
        return memberDTO;
    }
    public boolean joinIdCheck(String mid) throws Exception{
        return dao.idCheck(mid);
    }
    public void register(MemberDTO memberDTO) throws Exception{
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        System.out.println("memberVO: "+ memberVO);
        dao.insert(memberVO);
    }
    public void modify(MemberDTO memberDTO) throws Exception{
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        dao.update(memberVO);
    }
    public void removeMem(String mid) throws Exception{
        dao.deleteMemo(mid);
    }
    public void updateUUID(String mid, String UUid) throws Exception{
        dao.updateUUID(mid,UUid);
    }
    public MemberDTO getByUUID(String UUid) throws Exception{
        MemberVO memberVO = dao.selectUUID(UUid);
        MemberDTO memberDTO = modelMapper.map(memberVO,MemberDTO.class);
        return memberDTO;
    }
}
