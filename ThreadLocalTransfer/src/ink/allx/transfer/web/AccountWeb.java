package ink.allx.transfer.web;

import ink.allx.transfer.service.AccountService;

/**
 * @Author Allx
 * @Date 2021/9/6 22:54
 */
public class AccountWeb {
    public static void main(String[] args) {
        String outUser = "Jack";
        String inUser = "Rose";
        int money = 100;

        AccountService as = new AccountService();
        boolean result = as.transfer(outUser, inUser, money);

        if (result) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }
    }
}
