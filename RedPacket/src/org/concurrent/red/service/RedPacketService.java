package org.concurrent.red.service;

import org.concurrent.red.pojo.RedPacket;

public interface RedPacketService {
	public RedPacket getRedPacket(Long id);
	public int decreaseRedPacket(Long id);
}
