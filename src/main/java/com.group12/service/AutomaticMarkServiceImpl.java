package com.group12.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.AutomaticMarkDao;
import com.group12.entity.AutomaticMarkEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("automaticMarkService")
public class AutomaticMarkServiceImpl extends ServiceImpl<AutomaticMarkDao,AutomaticMarkEntity> implements AutomaticMarkService{
    @Override
    public Integer add(AutomaticMarkEntity automaticMarkEntity){

        return baseMapper.insert(automaticMarkEntity);
    }

    @Override
    public IPage<AutomaticMarkEntity> page(AutomaticMarkEntity automaticMarkEntity,int page,int pageline) {
        LambdaQueryWrapper<AutomaticMarkEntity> query = Wrappers.lambdaQuery();
        query.eq(AutomaticMarkEntity::getScore, automaticMarkEntity.getScore());

        if (page == 0) {
            page = 1;
        }
        if (pageline == 0) {
            pageline = 10;
        }
        IPage<AutomaticMarkEntity> ipage = Page.of(page, pageline);

        return baseMapper.selectPage(ipage, query);
    }

        @Override
        public int deleteById(Long id){

            return baseMapper.deleteById(id);
    }

    public List<AutomaticMarkEntity> listByCondition(AutomaticMarkEntity condition) {
        // 通过baseMapper调用相应的数据库查询方法，比如使用LambdaQueryWrapper构建条件查询
        LambdaQueryWrapper<AutomaticMarkEntity> queryWrapper = Wrappers.lambdaQuery(condition);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public void autoMark() {
        List<AutomaticMarkEntity> allRecords = baseMapper.selectList(null);
        for (AutomaticMarkEntity record : allRecords) {
            String questionType = record.getQuestionType();
            String correctAnswer = record.getCorrectAnswer().trim();
            String studentAnswer = record.getStudentAnswer().trim();
            int score = 0;
            if ("choice".equals(questionType)) {
                // 对于选择题，直接比较选项字符串是否相等（单选情况，多选需更复杂处理）
                if (correctAnswer.equals(studentAnswer)) {
                    score = 1;
                }
            } else if ("judgment".equals(questionType)) {
                // 对于判断题，统一转成小写后比较（假设正确答案存储为 "true" 或 "false" 格式）
                if (correctAnswer.toLowerCase().equals(studentAnswer.toLowerCase())) {
                    score = 1;
                }
            } else if ("fill_in_the_blank".equals(questionType)) {
                // 对于填空题，采用模糊匹配，去除空格、不区分大小写后比较（可按需优化匹配方式）
                correctAnswer = correctAnswer.replaceAll(" ", "").toLowerCase();
                studentAnswer = studentAnswer.replaceAll(" ", "").toLowerCase();
                if (correctAnswer.equals(studentAnswer)) {
                    score = 1;
                }
            }
            record.setScore((long) score);
            baseMapper.updateById(record);
        }
    }
}
