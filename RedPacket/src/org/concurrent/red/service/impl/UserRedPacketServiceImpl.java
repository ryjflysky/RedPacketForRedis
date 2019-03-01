package org.concurrent.red.service.impl;

import org.concurrent.red.dao.RedPacketDao;
import org.concurrent.red.dao.UserRedPacketDao;
import org.concurrent.red.pojo.RedPacket;
import org.concurrent.red.pojo.UserRedPacket;
import org.concurrent.red.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {
	
	@Autowired
	private RedPacketDao redPacketDao = null;
	@Autowired
	private UserRedPacketDao userRedPacketDao = null;
	private static final int FAILED = 0;
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int grabRedPacket(Long redPacketId, Long userId) {
		RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
		if (redPacket.getStock() > 0) {
			redPacketDao.decreaseRedPacket(redPacketId);
			UserRedPacket userRedPacket = new UserRedPacket();
			userRedPacket.setRedPacketId(redPacketId);
			userRedPacket.setAmount(redPacket.getUnitAmount());
			userRedPacket.setUserId(userId);
			userRedPacket.setNote("抢红包" + redPacketId);
			int result = userRedPacketDao.grabRedPacket(userRedPacket);
			return result;
		}
		return FAILED;
	}

	@Override
	public int deleteUserPacket(Long id) {
		return userRedPacketDao.deletePacket(id);
	}

}
