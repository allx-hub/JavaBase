package ink.allx.transfer.dao;

import ink.allx.transfer.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {
    public void out(String outUser, int money) throws SQLException {
        String sql = "update account set money = money - ? where name = ?";

        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, money);
        pstm.setString(2, outUser);
        pstm.executeUpdate();

        //连接不能在这里释放，service层中还需要使用
        JdbcUtils.releaseConnection(pstm,conn);
        //JdbcUtils.releaseConnection(pstm);
    }

    public void in(String inUser, int money) throws SQLException {
        String sql = "update account set money = money + ? where name = ?";

        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, money);
        pstm.setString(2, inUser);
        pstm.executeUpdate();

        JdbcUtils.releaseConnection(pstm, conn);
        //JdbcUtils.releaseConnection(pstm);
    }
} 
