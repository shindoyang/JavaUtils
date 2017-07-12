package shindo.Java.file;

import java.io.File;
//删除一个文件夹下面的所有文件，一种调用递归算法，一种调用windows命令，下面是程序代码
public class FileDelete {
    /** 
     * 通过调用系统命令删除一个文件夹及下面的所有文件 
     * @param file 
     */  
    public static void deleteFileByWinCom(File file){  
        Runtime rt = Runtime.getRuntime();  
        String cmd = null;  
        try{  
            if(file.isFile()){  
                cmd = "cmd.exe /c del /q/a/f/s "+file.getAbsolutePath();  
            }else{  
                cmd = "cmd.exe /c rd /s/q "+file.getAbsolutePath();  
            }  
            rt.exec(cmd);  
            System.out.println("成功执行了命令...");  
        }catch(Exception e){  
            System.out.println("调用系统命令失败了...");  
        }  
    }  
    
    /**
     * 通过递归调用删除一个文件夹及其下面的所有文件
     */
    public static void deleteFile(File file){
        if(file.isFile()){//表示该文件不是文件夹
            file.delete();
        }else{
            //首先得到当前的路径  
            String[] childFilePaths = file.list();
            for(String childFilePath : childFilePaths){
                File childFile = new File(file.getAbsolutePath()+"\\"+childFilePath);
                deleteFile(childFile);
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("D:\\demo");
        //deleteFileByWinCom(file);  
        deleteFile(file);
        
    }
}
