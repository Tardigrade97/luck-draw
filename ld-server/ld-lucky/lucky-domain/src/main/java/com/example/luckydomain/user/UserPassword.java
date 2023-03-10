package com.example.luckydomain.user;


import com.alibaba.nacos.common.utils.StringUtils;
import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.validator.ValidatorException;

@Getter
public class UserPassword {
    private final EncryptPassword encryptPassword;


    public UserPassword(String password) throws ValidatorException {
        if (StringUtils.isBlank(password)) {
            throw new ValidatorException("密码不能为空");
        }
        // 生成加密的密码
        this.encryptPassword = new EncryptPassword(generateEncryptPassword(password));
    }


    /**
     * 生成加密的密码
     *
     * @param password
     * @return
     */
    private String generateEncryptPassword(String password) {
        return DigestUtils.sha3_256Hex(password);
    }

    @Getter
    public static class EncryptPassword {
        private String password;

        public EncryptPassword(String encryptPassword) {
            this.password = encryptPassword;
        }
    }

    public Boolean isEqual(String password) {
        return this.encryptPassword.password.equals(generateEncryptPassword(password));
    }

}
