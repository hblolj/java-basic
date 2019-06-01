package com.hblolj.reflect;

import java.io.*;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/18
 * Time : 15:51
 */
public class MyClassLoader extends ClassLoader{

    private String path;

    private String classLoaderName;

    public MyClassLoader(ClassLoader parent, String path, String classLoaderName) {
        super(parent);
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    /**
     * 用户加载类文件
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {

        name = path + name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;

        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i;
            while ((i = in.read()) != -1){
                out.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
                if (in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
