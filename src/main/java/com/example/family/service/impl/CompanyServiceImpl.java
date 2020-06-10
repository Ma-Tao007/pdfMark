package com.example.family.service.impl;

import com.example.family.dto.LayuiPageResult;
import com.example.family.dto.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.family.entity.Company;
import com.example.family.mapper.CompanyMapper;
import com.example.family.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return companyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Company record) {
        return companyMapper.insert(record);
    }

    @Override
    public int insertSelective(Company record) {
        return companyMapper.insertSelective(record);
    }

    @Override
    public Company selectByPrimaryKey(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Company record) {
        return companyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Company record) {
        return companyMapper.updateByPrimaryKey(record);
    }

    @Override
    public LayuiPageResult getAllList(PageHelper pageHelper,Company company) {
        LayuiPageResult layuiPageResult = new LayuiPageResult();
        layuiPageResult.setCount(companyMapper.getCount(company));
        layuiPageResult.setData(companyMapper.getAllList(company,pageHelper));
        return layuiPageResult;
    }

    @Override
    public Boolean selectIsExit(Company company) {
        return null != companyMapper.isExitNo(company);
    }

}

