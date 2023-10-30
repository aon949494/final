package org.zerock.finals.dao;

import lombok.Cleanup;
import org.zerock.finals.domain.MemberVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public List<MemberVO> selectAll()throws Exception{
        String sql = "select * from tbl_member";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<MemberVO> list = new ArrayList<>();
        while (resultSet.next()){
            MemberVO memberVO = MemberVO.builder()
                    .mid(resultSet.getString("mid"))
                    .mpw(resultSet.getString("mpw"))
                    .mname(resultSet.getString("mname"))
                    .mage(resultSet.getDate("mage").toLocalDate())
                    .maddr(resultSet.getString("maddr"))
                    .build();
            list.add(memberVO);
        }
        return list;
    }
    public MemberVO getWithPassword(String mid, String mpw) throws Exception{
        String sql = "select * from tbl_member where mid=? and mpw=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,mid);
        preparedStatement.setString(2,mpw);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .mage(resultSet.getDate("mage").toLocalDate())
                .maddr(resultSet.getString("maddr"))
                .build();
        return memberVO;
    }
    public boolean idCheck(String mid) throws Exception{
        Boolean ck=false;
        String sql = "select * from tbl_member where mid=?";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,mid);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            mid = resultSet.getString("mid");
            ck=false;
            return ck;
        }catch (Exception e){
            ck=true;
        }
        return ck;
    }
    public void insert(MemberVO vo) throws Exception{
        String sql = "insert into tbl_member(mid, mpw, mname,mage,maddr) values(?,?,?,?,?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vo.getMid() );
        preparedStatement.setString(2, vo.getMpw());
        preparedStatement.setString(3, vo.getMname());
        preparedStatement.setDate(4, Date.valueOf(vo.getMage()));
        preparedStatement.setString(5,vo.getMaddr());
        preparedStatement.executeUpdate();
    }
    public void update(MemberVO vo) throws Exception{
        String sql = "update tbl_member set mpw=?,maddr=? where mid=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,vo.getMpw());
        preparedStatement.setString(2,vo.getMaddr());
        preparedStatement.setString(3,vo.getMid());
        preparedStatement.executeUpdate();
    }
    public void deleteMemo(String mid) throws Exception{
        String sql = "delete from tbl_memo where id=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, mid);
        preparedStatement.executeUpdate();
        deleteTodo(mid);
        deleteMem(mid);
    }
    public void deleteMem(String mid) throws Exception{
        String sql = "delete from tbl_member where mid=?";
        try{
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,mid);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("dao");
        }

    }
    public void deleteTodo(String mid) throws Exception{
        String sql = "delete from tbl_todo where id=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, mid);
        preparedStatement.executeUpdate();
    }
    public void updateUUID(String mid, String UUid) throws Exception{
        String sql = "update tbl_member set uuid=? where mid=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,UUid);
        preparedStatement.setString(2,mid);
        preparedStatement.executeUpdate();
    }

    public MemberVO selectUUID(String UUid) throws Exception{
        String sql = "select * from tbl_member where uuid=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,UUid);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        MemberVO vo = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .mage(resultSet.getDate("mage").toLocalDate())
                .maddr(resultSet.getString("maddr"))
                .uuid(resultSet.getString("uuid"))
                .build();
        return vo;
    }
    public void commit() throws Exception{
        String sql = "COMMIT TRAN";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
}
