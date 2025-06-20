package com.dyddeg.employmentguidance.mapper;

import com.dyddeg.employmentguidance.pojo.DTO.MessageStudentDTO;
import com.dyddeg.employmentguidance.pojo.entity.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Insert("insert into message(sender,info,rid) value(#{sender},#{info},#{rid})")
    void addMessage(Message message);
    @Select("select * from message,student where rid = #{rid} and student.sno=message.sender")
    List<MessageStudentDTO> findMessageByRid(long rid);

    @Delete("delete from message where mid = #{mid}")
    void deleteMessage(long mid);
}
