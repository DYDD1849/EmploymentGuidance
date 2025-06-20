package com.dyddeg.employmentguidance.controller;

import com.dyddeg.employmentguidance.pojo.DTO.MessageStudentDTO;
import com.dyddeg.employmentguidance.pojo.entity.Message;
import com.dyddeg.employmentguidance.pojo.entity.Recruit;
import com.dyddeg.employmentguidance.result.Result;
import com.dyddeg.employmentguidance.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/addMessage")
    public Result addMessage(@RequestBody Message message)
        {
            messageService.addMessage(message);
            return Result.success();
        }
        @PostMapping("/deleteMessage")
    public Result deleteMessage(@RequestBody Message msg)
            {
            messageService.deleteMessage(msg);
            return Result.success();
        }
        @PostMapping("/findMessage")
    public Result findMessageByRid(@RequestBody Recruit Recruit)
            {
            List<MessageStudentDTO> list = messageService.findMessageByRid(Recruit.getRid());
            return Result.success(list);
        }
}
