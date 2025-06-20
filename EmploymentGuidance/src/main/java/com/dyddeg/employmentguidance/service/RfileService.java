package com.dyddeg.employmentguidance.service;

import com.dyddeg.employmentguidance.mapper.RfileMapper;
import com.dyddeg.employmentguidance.pojo.entity.Rfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RfileService {

    @Autowired
    private RfileMapper fileMapper;
    public void addFile(Rfile file) {
        fileMapper.addFile(file);
    }
    public void deleteFile(long rid) {
        fileMapper.deleteFile(rid);
    }
    public List<Rfile> findFile(long rid) {
        return fileMapper.findFile(rid);
    }
}
