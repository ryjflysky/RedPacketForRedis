package org.concurrent.red.dao;

import org.concurrent.red.pojo.RedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPacketDao {
	/**
	 * 获取RedPacket信息
	 * @param id RedPacketId
	 * @return RedPacket
	 */
	public RedPacket getRedPacket(Long id);
	/**
	 * decreaseRedPacket
	 * @param id redPacketId
	 * @return update count
	 */
	public int decreaseRedPacket(Long id);
}
