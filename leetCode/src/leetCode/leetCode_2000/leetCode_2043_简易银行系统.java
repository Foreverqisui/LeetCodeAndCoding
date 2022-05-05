package leetCode.leetCode_2000;

/**
 * 输入：
 * ["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
 * [[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]
 * 输出：
 * [null, true, true, true, false, false]
 * 实现 Bank 类：
 *
 *     Bank(long[] balance) 使用下标从 0 开始的整数数组 balance 初始化该对象。
 *     boolean transfer(int account1, int account2, long money) 从编号为 account1 的账户
 *     向编号为 account2 的账户转帐 money 美元。如果交易成功，返回 true ，否则，返回 false 。
 *     boolean deposit(int account, long money) 向编号为 account 的账户存款 money 美元。如果交易成功，
 *     返回 true ；否则，返回 false 。
 *     boolean withdraw(int account, long money) 从编号为 account 的账户取款 money 美元。如果交易成功，
 *     返回 true ；否则，返回 false 。
 * */

public class leetCode_2043_简易银行系统 {
    class Bank {
        long[] balance;
        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1>balance.length||account2>balance.length||balance[account1-1]<money){
                return false;
            }
            balance[account1-1]-=money;
            balance[account2-1]+=money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (account>balance.length){
                return false;
            }
            balance[account-1]+=money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account>balance.length||balance[account-1]<money){
                return false;
            }
            balance[account-1]-=money;
            return true;
        }
    }
}
