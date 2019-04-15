package com.delu.springboot.autochess.user;

import com.delu.springboot.autochess.base.BaseService;
import com.delu.springboot.autochess.user.account.Account;
import com.delu.springboot.autochess.user.account.AccountDao;
import com.delu.springboot.autochess.user.account.dto.AccountDaoBaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by delu on 2019-03-19.
 */
@Service
public class UserService extends BaseService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    /**
     * 创建用户基本信息和用户帐户
     * @param user
     * @param account
     * @return
     */
    public void createUser(User user, Account account){

        // 查询用户是否已注册
        Account oldAccount = accountDao.findOne(dozerMapper.map(account, AccountDaoBaseDto.class));

        userDao.insertUser(user.getUserId(), user.getNickName(), user.getHeadImg());

        accountDao.insertAccount(account);
    }


//    /**
//     * 根据名字查找用户
//     */
//    public User selectUserByName(String name) {
//
//        List<User> userList = userDao.findAllUser();
//        System.out.println(userList);
//        return null;
//    }
//
//    /**
//     * 查找所有用户
//     */
//    public List<User> selectAllUser() {
//        return userDao.findAllUser();
//    }
//
//    /**
//     * 插入两个用户
//     */
//    public void insertService() {
//        userDao.insertUser("SnailClimb", 22, 3000.0);
//        userDao.insertUser("Daisy", 19, 3000.0);
//    }
//
//    /**
//     * 根据id 删除用户
//     */
//
//    public void deleteService(int id) {
//        userDao.deleteUser(id);
//    }
//
//    /**
//     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 SnailClimb 和 Daisy 的钱都不会改变。
//     */
//    @Transactional
//    public void changemoney() {
//        userDao.updateUser("SnailClimb", 22, 2000.0, 3);
//        // 模拟转账过程中可能遇到的意外状况
//        int temp = 1 / 0;
//        userDao.updateUser("Daisy", 19, 4000.0, 4);
//    }
}
