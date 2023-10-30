package org.zerock.finals.dao;

import lombok.Cleanup;
import org.zerock.finals.domain.MemoVO;
import org.zerock.finals.domain.TodoVO;
import org.zerock.finals.dto.MemoDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemoDAO {
    public LocalDate getTime() throws Exception{
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        LocalDate now = resultSet.getDate(1).toLocalDate();
        return now;
    }
    public void insert(MemoVO vo) throws Exception{
        String sql = "insert into tbl_memo(title,memo,dueDate,id) values(?,?,?,?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,vo.getTitle());
        preparedStatement.setString(2, vo.getMemo());
        preparedStatement.setDate(3, Date.valueOf(getTime()));
        preparedStatement.setString(4,vo.getId());
        preparedStatement.executeUpdate();
    }
    public List<MemoVO> selectAll(String id) throws Exception{
        String sql = "select * from tbl_memo where id=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<MemoVO> list = new ArrayList<>();
        while(resultSet.next()){
            MemoVO vo = MemoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .memo(resultSet.getString("memo"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .id(resultSet.getString("id"))
                    .build();
            list.add(vo);
        }
        return list;
    }
    public MemoVO selectOne(Long tno) throws Exception{
        String sql = "select * from tbl_memo where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        MemoVO vo = MemoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .memo(resultSet.getString("memo"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .id(resultSet.getString("id"))
                .build();
        return vo;
    }
    public void updateOne(MemoVO memoVO) throws Exception{
        String sql = "update tbl_memo set title=?,memo=?,dueDate=? where tno=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,memoVO.getTitle());
        preparedStatement.setString(2,memoVO.getMemo());
        preparedStatement.setDate(3, Date.valueOf(getTime()));
        preparedStatement.setLong(4,memoVO.getTno());
        preparedStatement.executeUpdate();
    }
    public void deleteOne(Long tno) throws Exception{
        String sql = "delete from tbl_memo where tno=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        preparedStatement.executeUpdate();
    }

    public void alter() throws Exception{
        String sql = "ALTER table tbl_memo auto_increment = 1";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
    public void set() throws Exception{
        String sql = "set @COUNT=0";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
    public void updat() throws Exception{
        String sql = "update tbl_memo set tno=@count:=@count+1";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
}
