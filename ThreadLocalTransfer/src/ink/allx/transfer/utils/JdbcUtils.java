package ink.allx.transfer.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    //ThreadLocal对象 : 将connection绑定在当前线程中
    private static final ThreadLocal<Connection> tl = new ThreadLocal();
    //C3P0数据库连接池对象属性
    private static final ComboPooledDataSource ds = new ComboPooledDataSource();

    //获取连接
    //原本是在连接池中获取连接
    //现在直接获取当前线程绑定的连接对象，如果连接对象是空的，再去连接池中获取连接，将此连接对象跟当前线程进行绑定
    public static Connection getConnection() throws SQLException {
        //取出当前线程绑定的connection对象
        Connection conn = tl.get();
        if (conn == null) {
            //如果没有，则从连接池中取出
            conn = ds.getConnection();
            //再将connection对象绑定到当前线程中
            tl.set(conn);
        }
        return conn;
    }

    //释放资源
    public static void releaseConnection(AutoCloseable... ios) {
        for (AutoCloseable io : ios) {
            if (io != null) {
                try {
                    io.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void commitAndClose(Connection conn) {
        try {
            if (conn != null) {
                //提交事务
                conn.commit();
                //解除绑定
                tl.remove();
                //释放连接
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackAndClose(Connection conn) {
        try {
            if (conn != null) {
                //回滚事务
                conn.rollback();
                //解除绑定
                tl.remove();
                //释放连接
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 
