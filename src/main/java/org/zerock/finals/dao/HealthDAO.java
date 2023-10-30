package org.zerock.finals.dao;

import lombok.Cleanup;
import org.zerock.finals.domain.HealthVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class HealthDAO {
    public void insert(HealthVO vo) throws Exception{
        String sql = "insert into tbl_health(id,height,weight,move,kal,dueDate) values(?,?,?,?,?,?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,vo.getId());
        preparedStatement.setInt(2,vo.getHeight());
        preparedStatement.setInt(3,vo.getWeight());
        preparedStatement.setString(4,vo.getMove());
        preparedStatement.setFloat(5,vo.getKal());
        preparedStatement.setDate(6, Date.valueOf(vo.getDueDate()));
        preparedStatement.executeUpdate();
    }
}
