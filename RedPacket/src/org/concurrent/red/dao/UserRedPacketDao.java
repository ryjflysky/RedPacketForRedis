package org.concurrent.red.dao;

import org.concurrent.red.pojo.UserRedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedPacketDao {
	/**
	 * insert redPacket message
	 * @param userRedPacket
	 * @return update count
	 */
	public int grabRedPacket(UserRedPacket userRedPacket);
	
	/**
	 * delete data
	 */
	public int deletePacket(Long id);
}
