package com.finn.blog.id.leaf;


import com.finn.blog.id.leaf.common.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}
