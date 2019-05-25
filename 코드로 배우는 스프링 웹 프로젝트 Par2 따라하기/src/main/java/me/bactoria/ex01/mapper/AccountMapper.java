package me.bactoria.ex01.mapper;

import org.apache.ibatis.annotations.Select;

public interface AccountMapper {
    @Select("SELECT name FROM ACCOUNT WHERE ID = 1")
    public String getAccount();

    public String getAccount2();
}
