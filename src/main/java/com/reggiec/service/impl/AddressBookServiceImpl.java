package com.reggiec.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggiec.entity.AddressBook;
import com.reggiec.mapper.AddressBookMapper;
import com.reggiec.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
        implements AddressBookService {
}
