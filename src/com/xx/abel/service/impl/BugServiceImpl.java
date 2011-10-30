package com.xx.abel.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.abel.bean.Bug;
import com.xx.abel.bean.Users;
import com.xx.abel.dao.intf.BugDao;
import com.xx.abel.service.intf.BugService;
import com.xx.abel.util.PageListData;

@Service
public class BugServiceImpl implements BugService {
	@Autowired
	private BugDao bugDao;

	@SuppressWarnings("static-access")
	public List<Bug> findAll(Integer start,Integer count) {
		Users user = UserServiceImpl.getUser();
		List<Bug> list;
		if(start==null){
			list = bugDao.list(UserServiceImpl.getUser().getId());
		}else{
			String hql = "from Bug where users.id="+user.getId()+" order by createTime desc";
			PageListData pd =  bugDao.findList(Bug.class, hql, null, 1, count);
			list = pd.getDataList();
//			list = bugDao.list(user.getId(),start,end);
		}
		if(user.getBugType()==0){
		List<Bug> l = new LinkedList<Bug>();
		for (Bug bug : list) {
			Calendar c = Calendar.getInstance();
			c.setTime(bug.getCreateTime());
			c.add(c.MONTH, -1);
			Date te = c.getTime();
			bug.setCreateTime(te);
			l.add(bug);
		}
		return l;
		}else
			return list;
	}

	public void save(Bug bug) {
		if (bug.getCreateTime() == null)
			bug.setCreateTime(new Date());
		bugDao.saveOrUpdate(bug);
	}

	public Bug findById(int id) {
		return bugDao.findById(Bug.class, id);
	}

	public void delete(Bug bug) {
		bugDao.deleteById(Bug.class,bug.getId());
	}

}
