package com.ctf.jvm.opcode;

import com.ctf.jvm.JvmClassLoader;
import com.ctf.jvm.lang.JvmClass;
import com.sun.tools.classfile.ClassFile;

import java.io.IOException;
import java.nio.file.Path;

/**
 * 字节码定义的 Java 类( 区别于 native 类 )
 */
public class JvmOpcodeClass implements JvmClass {

    private JvmClassLoader jvmClassLoader;
    private final ClassFile classFile;
    /**
     * 是否初始化
     */
    boolean inited = false;

    public JvmOpcodeClass(JvmClassLoader jvmClassLoader, ClassFile classFile) {
        this.jvmClassLoader = jvmClassLoader;
        this.classFile = classFile;
    }

    public JvmOpcodeClass read(JvmClassLoader jvmClassLoader, Path path)throws ClassNotFoundException{

        try {
            return new JvmOpcodeClass(jvmClassLoader,ClassFile.read(path));
        }catch (IOException e){
            throw new ClassNotFoundException(e.getMessage());
        }catch (Exception e){
            throw new InternalError();
        }
    }
}
