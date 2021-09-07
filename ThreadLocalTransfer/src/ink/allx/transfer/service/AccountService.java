package ink.allx.transfer.service;

import ink.allx.transfer.dao.AccountDao;
import ink.allx.transfer.utils.JdbcUtils;

import java.sql.Connection;

public class AccountService {
    public boolean transfer(String outUser, String inUser, int money) {
        AccountDao ad = new AccountDao();
        Connection conn = null;
        try {
            //线程并发情况下,为了保证每个线程使用各自的connection,故加锁
            //synchronized (AccountService.class) {
            //开启事务
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);

            // 转出
            //ad.out(outUser, money,conn);
            ad.out(outUser, money);
            int i = 10 / 0;
            // 转入
            ad.in(inUser, money);

            //成功提交
            JdbcUtils.commitAndClose(conn);
            //}
        } catch (Exception e) {
            e.printStackTrace();
            //失败回滚
            JdbcUtils.rollbackAndClose(conn);

            return false;
        }
        return true;
    }
}

