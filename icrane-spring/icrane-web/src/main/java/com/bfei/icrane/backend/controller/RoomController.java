package com.bfei.icrane.backend.controller;

import com.bfei.icrane.common.util.PageBean;
import com.bfei.icrane.core.models.Doll;
import com.bfei.icrane.core.models.DollInfo;
import com.bfei.icrane.core.models.DollRoomNew;
import com.bfei.icrane.core.models.DollRoomNewItem;
import com.bfei.icrane.core.models.vo.DollRoomNewItemAll;
import com.bfei.icrane.core.service.DollRoomNewItemService;
import com.bfei.icrane.core.service.DollRoomNewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: DollManageController
 * @Description: 娃娃机管理控制层
 * @author perry
 * @date 2017年10月19日 上午9:33:35
 * @version V1.0
 */
@Controller
@RequestMapping("/roomManage")
public class RoomController {
	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	@Autowired
	private DollRoomNewService dollRoomNewService;

	@Autowired
	private DollRoomNewItemService dollRoomNewItemService;

	@RequestMapping("/list")
	public String list(Integer name, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "20") Integer pageSize, HttpServletRequest request) throws Exception {
			logger.info("查询房间列表输入参数:name={},page={},pageSize={}", name, page, pageSize);
		try {
			if("".equals(name)){
				name=null;
			}
			PageBean<DollRoomNew> pageBean = dollRoomNewService.selectDollRoomNewList(page, pageSize,name);
			logger.info("查询房间列表结果:{}", pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("name", name);
			return "room/doll_room_list";
		} catch (Exception e) {
			logger.error("查询房间列表SystemError:" + e);
			throw e;
		}
	}

	//关联列表
	@RequestMapping("/roomMachineList")
	public String roomMachineList(Integer dollRoomId, String dollRoomName, @RequestParam(defaultValue = "1") Integer page,
					   @RequestParam(defaultValue = "50") Integer pageSize, HttpServletRequest request) throws Exception {
		logger.info("查询房间关联列表输入参数:name={},page={},pageSize={}", dollRoomId,dollRoomName, page, pageSize);
		try {
			if("".equals(dollRoomId)){
				dollRoomId=null;
			}
			if("".equals(dollRoomName)){
				dollRoomName=null;
			}
			PageBean<DollRoomNewItemAll> pageBean = dollRoomNewItemService.selectDollRoomNewItemList(page, pageSize,dollRoomId,dollRoomName);
			logger.info("查询房间关联列表结果:{}", pageBean.getList().toString());
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("dollRoomId", dollRoomId);
			request.setAttribute("dollRoomName", dollRoomName);
			return "room/doll_room_machine_list";
		} catch (Exception e) {
			logger.error("查询房间关联列表SystemError:" + e);
			throw e;
		}
	}

	/**
	 * @Title: dollDel
	 * @Description: 删除关联表
	 */
	@RequestMapping(value="/roomItemDel",method=RequestMethod.POST)
	@ResponseBody
	public String roomItemDel(Integer roomItemId) throws Exception{
		logger.info("删除房间id：{}",roomItemId);
		try {
			int result = dollRoomNewItemService.dollDollRoomNewItemDel(roomItemId);
			logger.error("删除房间结果：{}",result>0?"success":"fail");
			if(result>0) {
				return "1";
			}else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("删除房间SystemError："+e);
			throw e;
		}
	}


	//房间添加机器
	@RequestMapping("/roomItemToAdd")
	public String toItemAdd(Integer id,HttpServletRequest request) throws Exception {
		List<Doll> dolls = dollRoomNewItemService.selectDollByDollRoomItem();
		request.setAttribute("dolls",dolls);
		request.setAttribute("id",id);
		return "room/doll_room_machine_add";
	}

	@RequestMapping(value = "/roomItemAdd", method = RequestMethod.POST)
	@ResponseBody
	public String roomItemAdd(DollRoomNewItem dollRoomNewItem) throws Exception {
		logger.info("新增房间机器传入参数：{}", dollRoomNewItem.toString());
		try {
			int result = dollRoomNewItemService.insertSelective(dollRoomNewItem);
			logger.info("新增房间机器结果:{}", result > 0 ? "success" : "fail");
			if (result > 0) {
				return "1";
			} else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("新增房间机器SystemError：" + e);
			throw e;
		}
	}



	//添加房间
	@RequestMapping("/roomToAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
	    List<DollInfo> dollInfo = dollRoomNewService.selectDollInfoList();
		request.setAttribute("dollInfo",dollInfo);
		return "room/doll_room_add";
	}

	@RequestMapping(value = "/roomAdd", method = RequestMethod.POST)
	@ResponseBody
	public String roomAdd(DollRoomNew dollRoomNew) throws Exception {
		logger.info("新增房间传入参数：{}", dollRoomNew.toString());
		try {
			int result = dollRoomNewService.insertSelective(dollRoomNew);
			logger.info("新增房间结果:{}", result > 0 ? "success" : "fail");
			if (result > 0) {
				return "1";
			} else {
				return "0";
			}
		} catch (Exception e) {
			logger.error("新增房间SystemError：" + e);
			throw e;
		}
	}
	 /**
	 * @Title: dollDel
	 * @Description: 删除房间
	 */
	 @RequestMapping(value="/roomDel",method=RequestMethod.POST)
	 @ResponseBody
		 public String bannerDel(Integer roomId) throws Exception{
		 logger.info("删除房间id：{}",roomId);
	 try {
		 int result = dollRoomNewService.dollRoomNewDel(roomId);
		 logger.error("删除房间结果：{}",result>0?"success":"fail");
		 if(result>0) {
			 return "1";
		 }else {
			 return "0";
		 }
	 } catch (Exception e) {
		 logger.error("删除房间SystemError："+e);
		 throw e;
	 }
	 }

	 @RequestMapping("/toEditRoom")
	 public String toEditDoll(Integer id, HttpServletRequest request) throws
	 Exception{
	 logger.info("跳转编房间id:{}",id);
	 try {
		 List<DollInfo> dollInfo = dollRoomNewService.selectDollInfoList();
		 request.setAttribute("dollInfo",dollInfo);
		 DollRoomNew dollRoomNew = dollRoomNewService.getDollRoomNewById(id);
		 logger.info("编辑房间查询:{}",dollRoomNew.toString());
		 request.setAttribute("dollRoomNew", dollRoomNew);
		 return "room/doll_room_edit";
	 } catch (Exception e) {
		 logger.error("编辑房间SystemError："+e);
		 throw e;
	 }
	 }

	 /**
	 * 更新房间
	 */
	 @RequestMapping(value="/roomUpdate",method=RequestMethod.POST)
	 @ResponseBody
	 public String dollUpdate(DollRoomNew dollRoomNew) throws Exception{
		 logger.info("更新房间传入参数doll：{}",dollRoomNew.toString());
	 try {
		 int result = dollRoomNewService.updateByPrimaryKeySelective(dollRoomNew);
		 logger.info("更新房间结果：{}",result>0?"success":"fail");
		 if(result>0) {
		 return "1";
		 }else {
		 return "0";
	 }
	 } catch (Exception e) {
		 logger.error("更新房间SystemError："+e);
		 throw e;
	 }
	 }


}
