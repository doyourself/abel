package com.xx.abel.dao.impl;



import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Notepad;
import com.xx.abel.dao.intf.NotepadDao;

@SuppressWarnings("unchecked")
@Repository
public class NotepadDaoImpl extends BaseDAOImpl<Notepad, Integer> implements NotepadDao{

}
