package com.example.mpg.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.example.mpg.generator.MybatisAutoGenerator;
import org.junit.Test;

public class CodeGeneratorTest {

    @Test
    public void test1() {
        MybatisAutoGenerator autoGenerator = new MybatisAutoGenerator();
        autoGenerator.execute();
    }
}
