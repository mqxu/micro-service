package com.mqxu.usercenter.rocketmq;

import com.mqxu.usercenter.dao.BonusEventLogMapper;
import com.mqxu.usercenter.dao.UserMapper;
import com.mqxu.usercenter.domain.dto.UserAddBonusDTO;
import com.mqxu.usercenter.domain.entity.BonusEventLog;
import com.mqxu.usercenter.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName AddBonusListener
 * @Description TODO
 * @Author mqxu
 * @Date 2020/10/7
 **/
@Service
@RocketMQMessageListener(consumerGroup = "consumer", topic = "add-bonus")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddBonusListener implements RocketMQListener<UserAddBonusDTO> {
    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public void onMessage(UserAddBonusDTO userAddBonusDTO) {
        //1.为用户加积分
        Integer userId = userAddBonusDTO.getUserId();
        User user = this.userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + userAddBonusDTO.getBonus());
        this.userMapper.updateByPrimaryKeySelective(user);
        // 2.写积分日志
        this.bonusEventLogMapper.insert(BonusEventLog.builder()
                .userId(userId)
                .value(userAddBonusDTO.getBonus())
                .event("CONTRIBUTE")
                .createTime(new Date())
                .description("投稿加积分")
                .build()
        );
    }
}
