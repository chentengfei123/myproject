package com.ctf.jvm;

import com.ctf.jvm.lang.JvmClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JvmClassLoader {
    /**
     * 类搜索路径
     */
    private Path classPath;

    public JvmClassLoader(Path classPath) {
        this.classPath = classPath;
    }

    public JvmClass loadClass(String className)throws ClassNotFoundException{
        String fileName = classPath + "/"+className.replace(".", "/")+".class";

        Path path = Paths.get(fileName);
        // 如果文件存在加载文件字节码
        // 否则尝试通过虚拟机宿主加载指定类，并将加载后的类当做nativ类
        if(Files.exists(path)){

        }
        return null;

    }
}
