package web;

import java.io.File;

public class FileTreeBean
{
    public static void buildFileTree(File path, StringBuilder st){
        st.append("<ul>");
        if(!path.isFile()){
            File files[] = path.listFiles();
            for(File dirOrFile: files){
                st.append("<li>" + dirOrFile.getName() + "</li>");
                buildFileTree(dirOrFile, st);
            }
        }
        st.append("</ul>");
    }

    public FileTreeBean() {}

    public String getFileTree()
    {
        StringBuilder st = new StringBuilder();
        String userDir = System.getProperty("user.dir");
        buildFileTree(new File(userDir), st);
        return st.toString();
    }
}

