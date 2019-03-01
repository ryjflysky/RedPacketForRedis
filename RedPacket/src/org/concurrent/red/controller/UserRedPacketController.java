package org.concurrent.red.controller;

import java.util.HashMap;
import java.util.Map;

import org.concurrent.red.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserRedPacketController  {
	@Autowired
	private UserRedPacketService userRedPacketService = null;
	
	@RequestMapping(value = "index.do")
	public String getIndex() {
		System.out.println("getIndex Method");
		return "index";
	}
	@RequestMapping(value = "path.do")
	public String getPath() {
		System.out.println("getPath Method");
		return "path";
	}
	@RequestMapping(value = "redpacket.do")
	public String redPacket() {
		return "redpacket";
	}
	@RequestMapping(value = "deleteData.do")
	public String deleteData() {
		long index = 3527;
		for (;;) {
			int res = userRedPacketService.deleteUserPacket(index);
			if (res == 0) {
				break;
			}
			index++;
		}
		return "success";
	}
	@RequestMapping(value ="getredpacket.do")
	@ResponseBody
	public Map<String, Object> grapRedPacket(Long redPacketId, Long userId) {
		System.out.println("编号到达："+ redPacketId + "-" +  userId);
		int result = userRedPacketService.grabRedPacket(redPacketId, userId);
		Map<String, Object> retMap = new HashMap<>();
		boolean flag = result > 0;
//		boolean flag = true;
		retMap.put("success", flag);
		retMap.put("message", flag ? "抢红包成功" : "抢红包失败");
		return retMap;
	}
}
