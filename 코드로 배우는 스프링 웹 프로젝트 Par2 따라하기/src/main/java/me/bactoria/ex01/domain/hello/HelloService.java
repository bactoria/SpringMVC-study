package me.bactoria.ex01.domain.hello;

import lombok.RequiredArgsConstructor;
import me.bactoria.ex01.mapper.AccountMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final AccountMapper accountMapper;

    public String getAccount(){
        return accountMapper.getAccount();
    }

}
