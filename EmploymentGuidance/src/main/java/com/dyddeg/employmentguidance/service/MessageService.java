package com.dyddeg.employmentguidance.service;

import com.dyddeg.employmentguidance.mapper.MessageMapper;
import com.dyddeg.employmentguidance.pojo.DTO.MessageStudentDTO;
import com.dyddeg.employmentguidance.pojo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    public MessageMapper messageMapper;
    public void addMessage(Message message){
        messageMapper.addMessage(message);
    }
    public void deleteMessage(Message msg){
        messageMapper.deleteMessage(msg.getMid());
    }
    public List<MessageStudentDTO> findMessageByRid(long rid){
       return messageMapper.findMessageByRid(rid);
    }
}
