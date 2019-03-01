package org.concurrent.red.service;

public interface UserRedPacketService {
	public int grabRedPacket(Long redPacketId, Long userId);
	public int deleteUserPacket(Long id);
}
